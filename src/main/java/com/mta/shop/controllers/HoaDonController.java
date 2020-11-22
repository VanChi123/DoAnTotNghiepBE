package com.mta.shop.controllers;

import com.mta.shop.controllers.message.AppResponse;
import com.mta.shop.controllers.message.AppResponseFailure;
import com.mta.shop.controllers.message.AppResponseSuccess;
import com.mta.shop.controllers.message.binhluan.BinhLuanAddRequest;
import com.mta.shop.controllers.message.hoadon.HoaDonAddRequest;
import com.mta.shop.controllers.message.hoadon.HoaDonGetRequest;
import com.mta.shop.controllers.message.hoadon.HoaDonPaymentRequest;
import com.mta.shop.controllers.message.hoadon.HoaDonUpdatePaymentRequest;
import com.mta.shop.entities.GiamGia;
import com.mta.shop.entities.HoaDon;
import com.mta.shop.entities.KhachHangEntity;
import com.mta.shop.entities.TaiKhoanEntity;
import com.mta.shop.repository.GiamGiaRepository;
import com.mta.shop.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/order")
@RequiredArgsConstructor
public class HoaDonController {
    private final HoaDonService hoaDonService;
    private final KhachHangService khachHangService;
    private final GiamGiaRepository giamGiaRepository;

    // get hóa đơn
    @PostMapping("/get")
    public AppResponse addNew(@RequestBody HoaDonGetRequest request) {
        System.out.println("request:" + request);

        AppResponse appResponse;

        Optional<HoaDon> hoaDonResult = hoaDonService.findById(request.getId());
        if (hoaDonResult.isPresent()){

            appResponse = new AppResponseSuccess();
            appResponse.setData(hoaDonResult.get());
        }else {
            appResponse = new AppResponseFailure();
        }
        return appResponse;
    }

    // get all hóa đơn
    @GetMapping("/get-all")
    public AppResponse getAll() {

        AppResponse appResponse;

        List<HoaDon> hoaDonList = hoaDonService.getAll();
        if (hoaDonList.size()> 0){

            appResponse = new AppResponseSuccess();
            appResponse.setData(hoaDonList);
        }else {
            appResponse = new AppResponseFailure();
        }
        return appResponse;
    }


    // thêm mới hóa đơn
    @PostMapping("/add")
    public AppResponse addNew(@RequestBody HoaDonAddRequest request) {
        System.out.println("request:" + request);

        // lấy thông tin khách hàng đặt hàng
        KhachHangEntity kh = khachHangService.getKhachHangByUserName(request.getTenDangNhap());

        // lấy thông tin giảm giá snar phẩm
        GiamGia giamGia = giamGiaRepository.findById(request.getIdGiamGia()).get();

        HoaDon hoaDon = new HoaDon();
        hoaDon.setMaHoaDon("HD" + Math.random());
        hoaDon.setNgayTao(new java.sql.Timestamp(new Date().getTime()));

        hoaDon.setTrangThai(request.getTrangThai());
        hoaDon.setTongTien(request.getTongTien());
        hoaDon.setTongTienPhaiTra(request.getTongTienPhaiTra());
        hoaDon.setTienGiamGia(request.getTienGiamGia());

        hoaDon.setIdKhachHang(kh.getId());

        hoaDon.setIdGiamGia(giamGia.getId());
        hoaDon.setPhanTramGiamGia(giamGia.getTiLeGiam());

        Optional<HoaDon> hoaDonResult = Optional.ofNullable(hoaDonService.save(hoaDon));
        AppResponse appResponse;
        if (hoaDonResult.isPresent()){

            appResponse = new AppResponseSuccess();
            appResponse.setData(hoaDonResult.get());
        }else {
            appResponse = new AppResponseFailure();
        }
        return appResponse;
    }

    // cập nhật thanh toán hóa đơn
    @PostMapping("/update-payment")
    public AppResponse updatePaymentOrder(@RequestBody HoaDonUpdatePaymentRequest request) {
        System.out.println("request:" + request);

        AppResponse appResponse;

        HoaDon hoaDon = hoaDonService.findById(request.getId()).get();
        hoaDon.setTrangThai(request.getTrangThai());
        hoaDon.setHinhThucThanhToan(request.getHinhThucThanhToan());
        hoaDon.setSoTienDaTra(request.getSoTienDaTra());

        HoaDon hoaDonResult = hoaDonService.save(hoaDon);
        if (null != hoaDonResult){

            appResponse = new AppResponseSuccess();
            appResponse.setData(hoaDonResult);
        }else {
            appResponse = new AppResponseFailure();
        }
        return appResponse;
    }

    // cập nhật thanh toán hóa đơn
    @PostMapping("/payment")
    public AppResponse updatePaymentOrder(@RequestBody HoaDonPaymentRequest request) {
        System.out.println("request:" + request);

        AppResponse appResponse;

        HoaDon hoaDon = hoaDonService.findById(request.getIdHoaDon()).get();
        hoaDon.setTrangThai(request.getTrangThai());
        hoaDon.setHinhThucThanhToan(request.getHinhThucThanhToan());
        hoaDon.setSoTienDaTra(request.getSoTienDaTra());

        hoaDon.setIdNhanVien(request.getIdNhanVien());

        HoaDon hoaDonResult = hoaDonService.save(hoaDon);
        if (null != hoaDonResult){

            appResponse = new AppResponseSuccess();
            appResponse.setData(hoaDonResult);
        }else {
            appResponse = new AppResponseFailure();
        }
        return appResponse;
    }
}
