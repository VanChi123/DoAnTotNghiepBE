package com.mta.shop.controllers.message.binhluan;

import lombok.Data;

import java.time.Instant;

@Data
public class BinhLuanAddRequest {
    private Integer idSanPham;
    private String tenDangNhap;
    private Instant ngayGio;
    private String noiDung;
    private String tenKhachHang;
    private String soDienThoai;
}
