package com.mta.shop.controllers;

import com.mta.shop.controllers.message.*;
import com.mta.shop.entities.TaiKhoanEntity;
import com.mta.shop.repository.TaiKhoanServiceCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
@RestController
@CrossOrigin("*")
@RequestMapping("/account")
@RequiredArgsConstructor
public class TaiKhoanController {

    private final TaiKhoanServiceCustom taiKhoanServiceCustom;

    @PostMapping("/add")
    public AppResponse forgotPassword(@RequestBody AddAccountRequest request) throws MessagingException {
        System.out.println("request:" + request);
        TaiKhoanEntity taiKhoanEntity;
        if (request.getTypeAccount().equals("customer")){
           taiKhoanEntity  = taiKhoanServiceCustom.addCustomer(new TaiKhoanEntity(request.getUserName(), request.getPassword(), request.getEmail()));
        }else {
            taiKhoanEntity = taiKhoanServiceCustom.addEmployee(new TaiKhoanEntity(request.getUserName(), request.getPassword(), request.getEmail()) );
        }
        AppResponse appResponse = new AppResponseSuccess();
        appResponse.setData(taiKhoanEntity);
        return  appResponse;
    }
}
