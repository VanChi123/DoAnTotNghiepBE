package com.mta.shop.controllers;

import com.mta.shop.controllers.message.AppResponse;
import com.mta.shop.controllers.message.AppResponseSuccess;
import com.mta.shop.controllers.message.nhacungcap.AddNhaCungCapRequest;
import com.mta.shop.controllers.message.nhanvien.AddNhanVienRequest;
import com.mta.shop.entities.NhaCungCap;
import com.mta.shop.entities.NhanVienEntity;
import com.mta.shop.entities.QuyenSuDungEntity;
import com.mta.shop.entities.TaiKhoanEntity;
import com.mta.shop.service.NhaCungCapService;
import com.mta.shop.service.NhanVienService;
import com.mta.shop.service.QuyenSuDungService;
import com.mta.shop.service.TaiKhoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/ncc")
@RequiredArgsConstructor
public class NhaCungCapController {
    private final NhaCungCapService nhaCungCapService;

    // lấy tất cả
    @GetMapping(value = "/get-all")
    public AppResponse getAll(){
        AppResponse appResponse;

        List<NhaCungCap> nhaCungCaps = nhaCungCapService.getAll();

        appResponse = new AppResponseSuccess();
        appResponse.setData(nhaCungCaps);
        return appResponse;
    }

    // lấy tất cả paging
    @GetMapping(value = "/")
    public AppResponse getAllPaging(@RequestParam Integer pageNumber){
        AppResponse appResponse;

        Page<NhaCungCap> nhaCungCaps = nhaCungCapService.getAllPaging(pageNumber);

        appResponse = new AppResponseSuccess();
        appResponse.setData(nhaCungCaps);
        return appResponse;
    }

    // thêm mới
    @PostMapping(value = "/add")
    @Transactional
    public AppResponse add(@RequestBody AddNhaCungCapRequest request){
        AppResponse appResponse;

        NhaCungCap nhaCungCap = request.getNhaCungCap();

        NhaCungCap ncc = nhaCungCapService.saveOne(nhaCungCap);

        appResponse = new AppResponseSuccess();
        appResponse.setData(ncc);
        return appResponse;
    }

    // cập nhật
    @PostMapping(value = "/update-admin")
    @Transactional
    public AppResponse updateAdmin(@RequestBody AddNhaCungCapRequest request){
        AppResponse appResponse;

        NhaCungCap newNCC = request.getNhaCungCap();

        NhaCungCap ncc = nhaCungCapService.saveOne(newNCC);

        appResponse = new AppResponseSuccess();
        appResponse.setData(ncc);
        return appResponse;
    }

    // xóa
    @GetMapping(value = "/delete/{id}")
    public AppResponse delete(@PathVariable Integer id){
        AppResponse appResponse;

        nhaCungCapService.deleteById(id);

        appResponse = new AppResponseSuccess();
        return appResponse;
    }


}
