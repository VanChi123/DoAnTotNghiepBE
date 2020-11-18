package com.mta.shop.controllers;

import com.mta.shop.controllers.message.AddModelRequest;
import com.mta.shop.controllers.message.AppResponse;
import com.mta.shop.controllers.message.AppResponseSuccess;
import com.mta.shop.entities.ThuongHieuEntity;
import com.mta.shop.service.ThuongHieuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/model")
@RequiredArgsConstructor
public class ThuongHieuController {
    private final ThuongHieuService thuongHieuService;

    // thêm mới thương hiệu
    @GetMapping("/")
    public AppResponse getAll() {
        List<ThuongHieuEntity> thuongHieuEntityList = thuongHieuService.getAll();

        AppResponse appResponse = new AppResponseSuccess();
        appResponse.setData(thuongHieuEntityList);
        return appResponse;
    }

    // thêm mới thương hiệu
    @PostMapping("/add")
    public AppResponse addNew(@RequestBody AddModelRequest request) throws MessagingException {
        System.out.println("request:" + request);
        ThuongHieuEntity thuongHieuEntity = thuongHieuService.addThuongHieu(request.getNewThuongHieu());

        AppResponse appResponse = new AppResponseSuccess();
        appResponse.setData(thuongHieuEntity);
        return appResponse;
    }


}
