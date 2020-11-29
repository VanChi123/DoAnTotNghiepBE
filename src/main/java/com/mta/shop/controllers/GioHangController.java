package com.mta.shop.controllers;

import com.mta.shop.controllers.message.AppResponse;
import com.mta.shop.controllers.message.AppResponseSuccess;
import com.mta.shop.controllers.message.giohang.AddGioHangRequest;
import com.mta.shop.controllers.message.thuonghieu.AddModelRequest;
import com.mta.shop.entities.GioHang;
import com.mta.shop.entities.KhachHangEntity;
import com.mta.shop.entities.SanPhamEntity;
import com.mta.shop.entities.ThuongHieuEntity;
import com.mta.shop.repository.KhachHangRepository;
import com.mta.shop.repository.SanPhamRepository;
import com.mta.shop.service.GioHangService;
import com.mta.shop.service.ThuongHieuService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/cart")
@RequiredArgsConstructor
public class GioHangController {
    private final GioHangService gioHangService;
    private final SanPhamRepository sanPhamRepository;
    private final KhachHangRepository khachHangRepository;

    // lấy tấ cả
    @GetMapping("/")
    public AppResponse getAll(@RequestParam Integer pageNumber) {
        Page<GioHang> gioHangs = gioHangService.getAll(PageRequest.of(pageNumber, 10));

        AppResponse appResponse = new AppResponseSuccess();
        appResponse.setData(gioHangs);
        return appResponse;
    }

    // thêm mới + sửa
    @PostMapping("/add")
    public AppResponse addNew(@RequestBody AddGioHangRequest request) {
        System.out.println("request:" + request);
        GioHang gh = request.getGioHang();

        SanPhamEntity sanPhamEntity = sanPhamRepository.findById(request.getGioHang().getSanPhamEntity().getId()).get();
        System.out.println("id san pham" + sanPhamEntity.getId());

        KhachHangEntity khachHangEntity = khachHangRepository.findById(request.getGioHang().getKhachHangEntity().getId()).get();
        System.out.println("id kh" + khachHangEntity.getId());

        gh.setKhachHangEntity(khachHangEntity);
        gh.setSanPhamEntity(sanPhamEntity);

        GioHang gioHang = gioHangService.add(gh);

        AppResponse appResponse = new AppResponseSuccess();
        appResponse.setData(gioHang);
        return appResponse;
    }

    // xóa
    @GetMapping("/delete/{id}")
    public AppResponse delete(@PathVariable("id") Integer id) {
        System.out.println("id:" + id);

        gioHangService.delete(id);
        return new AppResponseSuccess();
    }


}
