package com.mta.shop.service.mapper;

import com.mta.shop.entities.KhachHangEntity;
import lombok.Data;

import java.util.Date;

@Data
public class KhachHangDTO {
    private int id;
    private String maKhachHang;
    private String tenKhachHang;
    private Date ngaySinh;
    private boolean gioiTinh;
    private String diaChi;
    private String soDienThoai;
    private int idTaiKhoan;
    private String img;

    private String imgBase64;
    private String fileTail;

    public KhachHangDTO(KhachHangEntity khachHangEntity) {
        this.id = khachHangEntity.getId();
        this.maKhachHang = khachHangEntity.getMaKhachHang();
        this.tenKhachHang = khachHangEntity.getTenKhachHang();
        this.ngaySinh = khachHangEntity.getNgaySinh();
        this.gioiTinh = khachHangEntity.getGioiTinh();
        this.diaChi = khachHangEntity.getDiaChi();
        this.soDienThoai = khachHangEntity.getSoDienThoai();
        this.idTaiKhoan = khachHangEntity.getIdTaiKhoan();
        this.img = khachHangEntity.getImg();
    }

    public KhachHangDTO(KhachHangEntity khachHangEntity, String imgBase64, String fileTail){
        this.id = khachHangEntity.getId();
        this.maKhachHang = khachHangEntity.getMaKhachHang();
        this.tenKhachHang = khachHangEntity.getTenKhachHang();
        this.ngaySinh = khachHangEntity.getNgaySinh();
        this.gioiTinh = khachHangEntity.getGioiTinh();
        this.diaChi = khachHangEntity.getDiaChi();
        this.soDienThoai = khachHangEntity.getSoDienThoai();
        this.idTaiKhoan = khachHangEntity.getIdTaiKhoan();
        this.img = khachHangEntity.getImg();

        this.imgBase64 = imgBase64;
        this.fileTail = fileTail;
    }
}
