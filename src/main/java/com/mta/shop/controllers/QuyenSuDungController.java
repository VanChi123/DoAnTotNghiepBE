package com.mta.shop.controllers;

import com.mta.shop.controllers.message.AppResponse;
import com.mta.shop.controllers.message.AppResponseSuccess;
import com.mta.shop.controllers.message.quyen.AddRoleRequest;
import com.mta.shop.entities.QuyenSuDungEntity;
import com.mta.shop.service.QuyenSuDungService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/role")
@RequiredArgsConstructor
public class QuyenSuDungController {
    private final QuyenSuDungService quyenSuDungService;

    // get all roles
    @GetMapping("/")
    public AppResponse getAllRole() {
        List<QuyenSuDungEntity> list = quyenSuDungService.findAll();

        AppResponse appResponse = new AppResponseSuccess();
        appResponse.setData(list);
        return appResponse;
    }

    // get all roles
    @GetMapping("/get-all")
    public AppResponse getAll(@RequestParam Integer pageNumber) {
        Page<QuyenSuDungEntity> list = quyenSuDungService.findAll(pageNumber);

        AppResponse appResponse = new AppResponseSuccess();
        appResponse.setData(list);
        return appResponse;
    }

    // thêm/ sửa
    @PostMapping("/add")
    public AppResponse add(@RequestBody AddRoleRequest request) {
        QuyenSuDungEntity quyenSuDungEntity = request.getQuyenSuDungEntity();

        QuyenSuDungEntity result = quyenSuDungService.add(quyenSuDungEntity);

        AppResponse appResponse = new AppResponseSuccess();
        appResponse.setData(result);
        return appResponse;
    }

    // delete
    @GetMapping("/delete/{id}")
    public AppResponse delete(@PathVariable Integer id) {
        quyenSuDungService.delete(id);

        return new AppResponseSuccess();
    }
}
