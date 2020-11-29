package com.mta.shop.controllers;

import com.mta.shop.controllers.message.AppResponse;
import com.mta.shop.controllers.message.AppResponseSuccess;
import com.mta.shop.entities.QuyenSuDungEntity;
import com.mta.shop.service.QuyenSuDungService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/role")
@RequiredArgsConstructor
public class QuyenSuDungController {
    private final QuyenSuDungService quyenSuDungService;

    // get all roles
    @GetMapping("/get-all")
    public AppResponse getAll() {
        List<QuyenSuDungEntity> list = quyenSuDungService.findAll();

        AppResponse appResponse = new AppResponseSuccess();
        appResponse.setData(list);
        return appResponse;
    }
}
