package com.mta.shop.controllers;

import com.mta.shop.controllers.message.*;
import com.mta.shop.entities.TaiKhoanEntity;
import com.mta.shop.repository.TaiKhoanRepositoryCustom;
import com.mta.shop.service.TaiKhoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@CrossOrigin("*")
@RequestMapping("/account")
@RequiredArgsConstructor
public class TaiKhoanController {

    private final TaiKhoanRepositoryCustom taiKhoanRepositoryCustom;
    private final TaiKhoanService taiKhoanService;

    // thêm mới tài khoản
    @PostMapping("/add")
    public AppResponse forgotPassword(@RequestBody AddAccountRequest request) throws MessagingException {
        System.out.println("request:" + request);
        TaiKhoanEntity taiKhoanEntity;
        if (request.getTypeAccount().equals("customer")) {
            taiKhoanEntity = taiKhoanRepositoryCustom.addCustomer(new TaiKhoanEntity(request.getUserName(), request.getPassword(), request.getEmail()));
        } else {
            taiKhoanEntity = taiKhoanRepositoryCustom.addEmployee(new TaiKhoanEntity(request.getUserName(), request.getPassword(), request.getEmail()));
        }
        AppResponse appResponse = new AppResponseSuccess();
        appResponse.setData(taiKhoanEntity);
        return appResponse;
    }

    // đổi mật khẩu
    @PostMapping("/change-password")
    public AppResponse updatePassword(@RequestBody UpdatePassword request) {
        System.out.println("request:" + request);
        AppResponse appResponse;
        TaiKhoanEntity taiKhoanEntity = taiKhoanService.updatePassword(request);
        if (null != taiKhoanEntity) {
            appResponse = new AppResponseSuccess();
            appResponse.setData(taiKhoanEntity);
        } else {
            appResponse = new AppResponseFailure();
        }
        return appResponse;
    }
}
