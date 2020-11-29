package com.mta.shop.controllers;

import com.mta.shop.controllers.message.AppResponse;
import com.mta.shop.controllers.message.AppResponseSuccess;
import com.mta.shop.controllers.message.loaisanpham.AddCategoryRequest;
import com.mta.shop.controllers.message.star.AddStarRequest;
import com.mta.shop.entities.LoaiSanPham;
import com.mta.shop.entities.Star;
import com.mta.shop.service.LoaiSanPhamService;
import com.mta.shop.service.StarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/star")
@RequiredArgsConstructor
public class StarController {
    private final StarService starService;

    // lấy tất cả
    @GetMapping("/")
    public AppResponse getAll() {
        List<Star> starList = starService.getAll();

        AppResponse appResponse = new AppResponseSuccess();
        appResponse.setData(starList);
        return appResponse;
    }

    // thêm mới + sửa
    @PostMapping("/add")
    public AppResponse addNew(@RequestBody AddStarRequest request){
        System.out.println("request:" + request);
        Star star = starService.addNew(request.getStar());

        AppResponse appResponse = new AppResponseSuccess();
        appResponse.setData(star);
        return appResponse;
    }

    // xóa
    @GetMapping("/delete/{id}")
    public AppResponse delete(@PathVariable Integer id) {
        System.out.println("id:" + id);

        starService.delete(id);
        return new AppResponseSuccess();
    }

}
