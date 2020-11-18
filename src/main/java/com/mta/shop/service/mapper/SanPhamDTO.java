package com.mta.shop.service.mapper;

import com.mta.shop.entities.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamDTO {
    private Integer id;
    private String maSanPham;
    private String tenSanPham;
    private Float gia;
    private String doiTuongSuDung;
    private Float kichThuocBeMat;
    private String chatLieuMatKinh;
    private String chatLieuDay;
    private Float doDay;
    private Float doDai;
    private Float doRongCuaDay;
    private String kieuKhoa;
    private String chatLieuVoMay;
    private String may;
    private String khaNangChiuNuoc;
    private Integer giamGia;
    private String img;
    private Date ngayCapNhap;

    private String imgBase64;
    private String fileTail;

    private ThuongHieuEntity thuongHieuEntity;
    private LoaiSanPham loaiSanPham;
    private Star star;

    private Collection<BinhLuan> binhLuans;

    public SanPhamDTO(SanPhamEntity sanPhamEntity, String imgBase64, String fileTail ){
        this.id = sanPhamEntity.getId();
        this.maSanPham = sanPhamEntity.getMaSanPham();
        this.tenSanPham = sanPhamEntity.getTenSanPham();
        this.gia = sanPhamEntity.getGia();
        this.doiTuongSuDung = sanPhamEntity.getDoiTuongSuDung();
        this.kichThuocBeMat = sanPhamEntity.getKichThuocBeMat();
        this.chatLieuMatKinh = sanPhamEntity.getChatLieuMatKinh();
        this.chatLieuDay = sanPhamEntity.getChatLieuDay();
        this.doDay = sanPhamEntity.getDoDay();
        this.doDai = sanPhamEntity.getDoDai();
        this.doRongCuaDay = sanPhamEntity.getDoRongCuaDay();
        this.kieuKhoa = sanPhamEntity.getKieuKhoa();
        this.chatLieuVoMay = sanPhamEntity.getChatLieuVoMay();
        this.may = sanPhamEntity.getMay();
        this.khaNangChiuNuoc = sanPhamEntity.getKhaNangChiuNuoc();
        this.giamGia = sanPhamEntity.getGiamGia();
        this.img = sanPhamEntity.getImg();
        this.ngayCapNhap = sanPhamEntity.getNgayCapNhap();

        this.thuongHieuEntity = sanPhamEntity.getThuongHieuEntity();
        this.loaiSanPham = sanPhamEntity.getLoaiSanPham();
        this.star = sanPhamEntity.getStar();

        this.binhLuans = sanPhamEntity.getBinhLuans();

        this.imgBase64 = imgBase64;
        this.fileTail = fileTail;
    }
}
