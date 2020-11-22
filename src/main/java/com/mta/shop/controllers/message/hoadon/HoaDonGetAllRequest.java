package com.mta.shop.controllers.message.hoadon;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class HoaDonGetAllRequest {

    private int pageSize;
    private int pageNumber;
    private String maHoaDon;
    private String ngayTao;
    private List<Integer> idKhachHang;
    private List<Integer> trangThai;
    private Float hinhThucThanhToan;
}
