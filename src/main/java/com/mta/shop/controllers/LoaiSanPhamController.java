package com.mta.shop.controllers;

import com.mta.shop.controllers.message.loaisanpham.AddCategoryRequest;
import com.mta.shop.controllers.message.thuonghieu.AddModelRequest;
import com.mta.shop.controllers.message.AppResponse;
import com.mta.shop.controllers.message.AppResponseSuccess;
import com.mta.shop.entities.LoaiSanPham;
import com.mta.shop.entities.ThuongHieuEntity;
import com.mta.shop.service.LoaiSanPhamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/category")
@RequiredArgsConstructor
public class LoaiSanPhamController {
    private final LoaiSanPhamService loaiSanPhamService;

    // lấy tất cả loại sản phẩm
    @GetMapping("/")
    public AppResponse getAll() {
        List<LoaiSanPham> loaiSanPhamEntityList = loaiSanPhamService.getAll();

        AppResponse appResponse = new AppResponseSuccess();
        appResponse.setData(loaiSanPhamEntityList);
        return appResponse;
    }

    // thêm mới + sửa
    @PostMapping("/add")
    public AppResponse addNew(@RequestBody AddCategoryRequest request){
        System.out.println("request:" + request);
        LoaiSanPham loaiSanPham = loaiSanPhamService.addNew(request.getLoaiSanPham());

        AppResponse appResponse = new AppResponseSuccess();
        appResponse.setData(loaiSanPham);
        return appResponse;
    }

    // xóa
    @GetMapping("/delete/{id}")
    public AppResponse delete(@PathVariable Integer id) {
        System.out.println("id:" + id);

        loaiSanPhamService.delete(id);
        return new AppResponseSuccess();
    }

}
