package com.mta.shop.controllers;

import com.mta.shop.controllers.message.AppResponse;
import com.mta.shop.controllers.message.AppResponseSuccess;
import com.mta.shop.controllers.message.giamgia.AddGiamGiaRequest;
import com.mta.shop.controllers.message.quyen.AddRoleRequest;
import com.mta.shop.entities.GiamGia;
import com.mta.shop.entities.QuyenSuDungEntity;
import com.mta.shop.service.GiamGiaService;
import com.mta.shop.service.QuyenSuDungService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/giam-gia")
@RequiredArgsConstructor
public class GiamGiaController {
    private final GiamGiaService giamGiaService;

    // get all roles
    @GetMapping("/get-all")
    public AppResponse getAll(@RequestParam Integer pageNumber) {
        Page<GiamGia> list = giamGiaService.getAllPaging(pageNumber);

        AppResponse appResponse = new AppResponseSuccess();
        appResponse.setData(list);
        return appResponse;
    }

    // thêm/ sửa
    @PostMapping("/add")
    public AppResponse add(@RequestBody AddGiamGiaRequest request) {
        GiamGia giamGia = request.getGiamGia();

        GiamGia result = giamGiaService.saveOne(giamGia);

        AppResponse appResponse = new AppResponseSuccess();
        appResponse.setData(result);
        return appResponse;
    }

    // delete
    @GetMapping("/delete/{id}")
    public AppResponse delete(@PathVariable Integer id) {
        giamGiaService.deleteById(id);

        return new AppResponseSuccess();
    }
}
