package com.mta.shop.controllers.message.hoadon;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class HoaDonPaymentRequest {
    private Integer idNhanVien;

    private int idHoaDon;
    private Integer trangThai;
    private Integer hinhThucThanhToan;
    private Float soTienDaTra;
}
