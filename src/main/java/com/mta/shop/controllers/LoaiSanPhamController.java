package com.mta.shop.controllers;

import com.mta.shop.controllers.message.AppResponse;
import com.mta.shop.controllers.message.AppResponseSuccess;
import com.mta.shop.entities.LoaiSanPham;
import com.mta.shop.service.LoaiSanPhamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

//    // thêm mới thương hiệu
//    @PostMapping("/add")
//    public AppResponse addNew(@RequestBody AddModelRequest request) throws MessagingException {
//        System.out.println("request:" + request);
//        ThuongHieuEntity thuongHieuEntity = thuongHieuService.addThuongHieu(request.getNewThuongHieu());
//
//        AppResponse appResponse = new AppResponseSuccess();
//        appResponse.setData(thuongHieuEntity);
//        return appResponse;
//    }

}
