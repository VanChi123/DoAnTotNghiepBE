package com.mta.shop.controllers;

import com.mta.shop.controllers.message.AppResponse;
import com.mta.shop.controllers.message.AppResponseFailure;
import com.mta.shop.controllers.message.AppResponseSuccess;
import com.mta.shop.controllers.message.giamgia.AddGiamGiaRequest;
import com.mta.shop.controllers.message.phieunhap.AddPhieuNhapRequest;
import com.mta.shop.entities.GiamGia;
import com.mta.shop.entities.NhaCungCap;
import com.mta.shop.entities.NhanVienEntity;
import com.mta.shop.entities.PhieuNhap;
import com.mta.shop.service.GiamGiaService;
import com.mta.shop.service.NhaCungCapService;
import com.mta.shop.service.NhanVienService;
import com.mta.shop.service.PhieuNhapService;
import com.mta.shop.service.mapper.PhieuNhapDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/phieu-nhap")
@RequiredArgsConstructor
public class PhieuNhapController {
    private final PhieuNhapService phieuNhapService;
    private final NhaCungCapService nhaCungCapService;
    private final NhanVienService nhanVienService;

    // get all
    @GetMapping("/get-all")
    public AppResponse getAll(@RequestParam Integer pageNumber) {
        Page<PhieuNhap> list = phieuNhapService.getAllPaging(pageNumber);

        AppResponse appResponse = new AppResponseSuccess();
        appResponse.setData(list);
        return appResponse;
    }


    // get all dto
    @GetMapping("/get-all-dto")
    public AppResponse getAll() {
        List<PhieuNhapDTO> list = phieuNhapService.getAllDTO();

        AppResponse appResponse = new AppResponseSuccess();
        appResponse.setData(list);
        return appResponse;
    }


    // thêm
    @PostMapping("/add")
    public AppResponse add(@RequestBody AddPhieuNhapRequest request) {
        AppResponse appResponse;
        PhieuNhap phieuNhap = request.getPhieuNhap();

        Integer idNCC = phieuNhap.getNhaCungCap().getId();

        if (null != idNCC) {
            Optional<NhaCungCap> nhaCungCapOptional = nhaCungCapService.findOne(idNCC);
            if (nhaCungCapOptional.isPresent()) {
                phieuNhap.setNhaCungCap(nhaCungCapOptional.get());
            }
        } else {
            phieuNhap.setNhaCungCap(null);
        }

        Integer idNhanVien = phieuNhap.getNhanVienEntity().getId();
        if (null != idNhanVien) {
            Optional<NhanVienEntity> nhanVienEntityOptional = nhanVienService.findOne(idNhanVien);
            if (nhanVienEntityOptional.isPresent()) {
                phieuNhap.setNhanVienEntity(nhanVienEntityOptional.get());
            }
        } else {
            phieuNhap.setNhanVienEntity(null);
        }

        phieuNhap.setNgayNhap(new Date(System.currentTimeMillis()));
        phieuNhap.setTongTien((float) 0);

        PhieuNhap phieuNhapResult = phieuNhapService.saveOne(phieuNhap);

        if (null != phieuNhapResult) {
            appResponse = new AppResponseSuccess();
        } else {
            appResponse = new AppResponseFailure();
        }

        return appResponse;
    }

    // thêm
    @PostMapping("/update")
    public AppResponse update(@RequestBody AddPhieuNhapRequest request) {
        AppResponse appResponse;
        PhieuNhap phieuNhap = request.getPhieuNhap();

        Integer idNCC = phieuNhap.getNhaCungCap().getId();

        if (null != idNCC) {
            Optional<NhaCungCap> nhaCungCapOptional = nhaCungCapService.findOne(idNCC);
            if (nhaCungCapOptional.isPresent()) {
                phieuNhap.setNhaCungCap(nhaCungCapOptional.get());
            }
        } else {
            phieuNhap.setNhaCungCap(null);
        }

        Integer idNhanVien = phieuNhap.getNhanVienEntity().getId();
        if (null != idNhanVien) {
            Optional<NhanVienEntity> nhanVienEntityOptional = nhanVienService.findOne(idNhanVien);
            if (nhanVienEntityOptional.isPresent()) {
                phieuNhap.setNhanVienEntity(nhanVienEntityOptional.get());
            }
        } else {
            phieuNhap.setNhanVienEntity(null);
        }

        PhieuNhap phieuNhapResult = phieuNhapService.saveOne(phieuNhap);

        if (null != phieuNhapResult) {
            appResponse = new AppResponseSuccess();
        } else {
            appResponse = new AppResponseFailure();
        }

        return appResponse;
    }


    // delete
    @GetMapping("/delete/{id}")
    public AppResponse delete(@PathVariable Integer id) {
        phieuNhapService.deleteById(id);

        return new AppResponseSuccess();
    }
}
