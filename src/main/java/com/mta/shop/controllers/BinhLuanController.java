package com.mta.shop.controllers;

import com.mta.shop.controllers.message.AppResponse;
import com.mta.shop.controllers.message.AppResponseFailure;
import com.mta.shop.controllers.message.AppResponseSuccess;
import com.mta.shop.controllers.message.binhluan.BinhLuanAddRequest;
import com.mta.shop.entities.TaiKhoanEntity;
import com.mta.shop.service.BinhLuanService;
import com.mta.shop.service.SanPhamService;
import com.mta.shop.service.TaiKhoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/comment")
@RequiredArgsConstructor
public class BinhLuanController {
    private final BinhLuanService binhLuanService;
    private final TaiKhoanService taiKhoanService;
    private final SanPhamService sanPhamService;

    // thêm mới bình luận
    @PostMapping("/add")
    public AppResponse addNew(@RequestBody BinhLuanAddRequest request) {
        System.out.println("request:" + request);

        Optional<TaiKhoanEntity> taiKhoanEntity = taiKhoanService.getAccountByTenDangNhap(request.getTenDangNhap());
        AppResponse appResponse;
        if (taiKhoanEntity.isPresent()){
            binhLuanService.addBinhLuan(taiKhoanEntity.get().getId(),
                    request.getIdSanPham(),
                    request.getNgayGio(),
                    request.getNoiDung(),
                    request.getTenKhachHang(),
                    request.getSoDienThoai());

            appResponse = new AppResponseSuccess();
        }else {
            appResponse = new AppResponseFailure();
        }
        return appResponse;
    }
}
