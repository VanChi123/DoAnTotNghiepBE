package com.mta.shop.controllers;

import com.mta.shop.controllers.message.AppResponse;
import com.mta.shop.controllers.message.AppResponseSuccess;
import com.mta.shop.controllers.message.chitietphieunhap.AddChiTietPhieuNhapRequest;
import com.mta.shop.controllers.message.giamgia.AddGiamGiaRequest;
import com.mta.shop.entities.ChiTietPhieuNhap;
import com.mta.shop.entities.ChiTietPhieuNhapPK;
import com.mta.shop.entities.GiamGia;
import com.mta.shop.entities.PhieuNhap;
import com.mta.shop.service.ChiTietPhieuNhapService;
import com.mta.shop.service.GiamGiaService;
import com.mta.shop.service.PhieuNhapService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/ctpn")
@RequiredArgsConstructor
public class ChiTietPhieuNhapController {
    private final ChiTietPhieuNhapService chiTietPhieuNhapService;
    private final PhieuNhapService phieuNhapService;

    // get all
    @GetMapping("/get-all")
    public AppResponse getAll(@RequestParam Integer pageNumber) {
        Page<ChiTietPhieuNhap> list = chiTietPhieuNhapService.getAllPaging(pageNumber);

        AppResponse appResponse = new AppResponseSuccess();
        appResponse.setData(list);
        return appResponse;
    }

    // thêm/ sửa
    @PostMapping("/add")
    public AppResponse add(@RequestBody AddChiTietPhieuNhapRequest request) {
        ChiTietPhieuNhap chiTietPhieuNhap = request.getChiTietPhieuNhap();

        ChiTietPhieuNhap result = chiTietPhieuNhapService.saveOne(chiTietPhieuNhap);

        if (null != result) {
            Optional<PhieuNhap> phieuNhap = phieuNhapService.findOne(request.getChiTietPhieuNhap().getChiTietPhieuNhapPK().getIdPhieuNhap());

            if (null != phieuNhap) {
                PhieuNhap phieuNhap1 = phieuNhap.get();
                phieuNhap1.setTongTien(phieuNhap1.getTongTien() + result.getThanhTien());

                phieuNhapService.saveOne(phieuNhap1);
            }
        }

        AppResponse appResponse = new AppResponseSuccess();
        appResponse.setData(result);
        return appResponse;
    }

    // delete
    @GetMapping("/delete/{idPhieuNhap}/{idSanPham}")
    public AppResponse delete(@PathVariable int idPhieuNhap, @PathVariable int idSanPham) {
        ChiTietPhieuNhapPK ct = new ChiTietPhieuNhapPK(idSanPham, idPhieuNhap);
        chiTietPhieuNhapService.deleteById(ct);

        return new AppResponseSuccess();
    }
}
