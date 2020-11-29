package com.mta.shop.controllers;

import com.mta.shop.controllers.message.thuonghieu.AddModelRequest;
import com.mta.shop.controllers.message.AppResponse;
import com.mta.shop.controllers.message.AppResponseSuccess;
import com.mta.shop.entities.ThuongHieuEntity;
import com.mta.shop.service.ThuongHieuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/model")
@RequiredArgsConstructor
public class ThuongHieuController {
    private final ThuongHieuService thuongHieuService;

    // lấy tấ cả thương hiệu
    @GetMapping("/")
    public AppResponse getAll() {
        List<ThuongHieuEntity> thuongHieuEntityList = thuongHieuService.getAll();

        AppResponse appResponse = new AppResponseSuccess();
        appResponse.setData(thuongHieuEntityList);
        return appResponse;
    }

    // thêm mới + sửa thương hiệu
    @PostMapping("/add")
    public AppResponse addNew(@RequestBody AddModelRequest request) {
        System.out.println("request:" + request);
        ThuongHieuEntity thuongHieuEntity = thuongHieuService.addThuongHieu(request.getNewThuongHieu());

        AppResponse appResponse = new AppResponseSuccess();
        appResponse.setData(thuongHieuEntity);
        return appResponse;
    }

    // xóa thương hiệu
    @GetMapping("/delete/{id}")
    public AppResponse delete(@PathVariable("id") Integer id) {
        System.out.println("id:" + id);

        thuongHieuService.deleteModel(id);
        AppResponse appResponse = new AppResponseSuccess();
        return appResponse;
    }


}
