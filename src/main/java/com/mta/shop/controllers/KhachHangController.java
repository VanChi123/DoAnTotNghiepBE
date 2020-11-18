package com.mta.shop.controllers;

import com.mta.shop.controllers.message.*;
import com.mta.shop.entities.KhachHangEntity;
import com.mta.shop.service.KhachHangService;
import com.mta.shop.service.mapper.KhachHangDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin("*")
@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class KhachHangController {
    private final KhachHangService khachHangService;

    // lấy thông tin khách hàng
    @PostMapping(value = "/get")
    public AppResponse getCustomer(@RequestBody GetKhachHangRequest request) throws IOException {
        System.out.println("nhận body: " + request.toString());
        AppResponse appResponse;
        if (request.getTypeAccount().equals("customer")){
            KhachHangEntity khachHangEntity = khachHangService.getKhachHangByUserName(request.getUserName());

            String imgBase64 = khachHangService.getImgBase64(khachHangEntity.getImg());
            System.out.println("img baser 64: " + imgBase64);
            KhachHangDTO khachHangDTO = new KhachHangDTO(khachHangEntity, imgBase64, "" );

            appResponse = new AppResponseSuccess();
            appResponse.setData(khachHangDTO);
            return appResponse;
        }

        return  new AppResponseSuccess();

    }

//    // cập nhật thông tin cá nhân
//    @PostMapping(value = "/update")
//    public AppResponse updateCustomer(@RequestBody UpdateInformationCustomerRequest request) {
//        System.out.println("nhận body: " + request.toString());
//        AppResponse appResponse;
//        KhachHangEntity khachHangEntity = khachHangService.updateCustomer(request);
//        if (null != khachHangEntity){
//            appResponse = new AppResponseSuccess();
//            appResponse.setData(khachHangEntity);
//            return appResponse;
//        }else {
//            appResponse = new AppResponseFailure();
//        }
//        return  new AppResponseSuccess();
//
//    }

    // cập nhật thông tin cá nhân
    @PostMapping(value = "/update")
    public AppResponse updateCustomer(@RequestBody UpdateInformationCustomerRequest request) throws IOException {
        AppResponse appResponse;

        KhachHangEntity khachHangEntity = khachHangService.updateCustomer(request);
        if (null != khachHangEntity){
            appResponse = new AppResponseSuccess();

            String imgBase64 = khachHangService.getImgBase64(khachHangEntity.getImg());
            KhachHangDTO khachHangDTO = new KhachHangDTO(khachHangEntity, imgBase64, "" );
            appResponse.setData(khachHangDTO);
            return appResponse;
        }else {
            appResponse = new AppResponseFailure();
        }
        return  appResponse;
    }

}
