package com.mta.shop.controllers.message.hoadon;

import com.mta.shop.entities.SanPhamEntity;
import lombok.Data;

import javax.persistence.Column;
import java.sql.Timestamp;

@Data
public class HoaDonAddRequest {

    private Timestamp ngayTao;
    private Float tongTien;
    private Float tongTienPhaiTra;
    private Integer phanTramGiamGia;
    private Float tienGiamGia;
    private String maHoaDon;
    private Integer trangThai;

    private Integer idGiamGia;
    private String tenDangNhap;
    private Integer idNhanVien;
}
