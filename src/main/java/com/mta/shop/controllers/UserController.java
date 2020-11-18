package com.mta.shop.controllers;

import com.mta.shop.controllers.message.*;
import com.mta.shop.entities.TaiKhoanEntity;
import com.mta.shop.repository.UserRepositoryCustomImpl;
import com.mta.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    //private final UserRepositoryCustomImpl userService;

    private final UserService userService;

    // ok: đăng nhập
    @PostMapping(value = "/login")
    public AppResponse login(@RequestBody LoginRequest loginRequest) {
        AppResponse appResponse;
        System.out.println("login REqueetst" + loginRequest.getUserName() + " ---" + loginRequest.getPassword());
        TaiKhoanEntity taiKhoanEntity = userService.checkLogin(loginRequest.getUserName(), loginRequest.getPassword());
        if (null != taiKhoanEntity){
            appResponse = new AppResponseSuccess();
            appResponse.setData(taiKhoanEntity);
        }else {
            appResponse = new AppResponseFailure();
            appResponse.setData(null);
        }
        return appResponse;
    }

    @PostMapping("/forgot-password")
    public AppResponse forgotPassword(@RequestBody GetOTPRequest request) throws MessagingException {
        GetOTPResponse response = userService.generateOtp(request, "doi mat khau");
        AppResponse appResponse = new AppResponseSuccess();
        appResponse.setData(response);
        return  appResponse;
    }
}
