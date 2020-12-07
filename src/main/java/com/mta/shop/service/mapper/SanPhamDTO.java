package com.mta.shop.service.mapper;

import com.mta.shop.entities.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamDTO {
    private Integer id;
    private String maSanPham;
    private String tenSanPham;
    private Integer giamGia;

    private String anhDaiDien;
    private Float gia;

    private String imgBase64;
    private String fileTail;

    private ThuongHieuEntity thuongHieuEntity;
    private LoaiSanPham loaiSanPham;
    private Star star;

    private Collection<BinhLuan> binhLuans;
    private Collection<TaiKhoanEntity> taiKhoanEntities;

    public SanPhamDTO(SanPhamEntity sanPhamEntity, String imgBase64, String fileTail ){
        this.id = sanPhamEntity.getId();
        this.maSanPham = sanPhamEntity.getMaSanPham();
        this.tenSanPham = sanPhamEntity.getTenSanPham();
        this.giamGia = sanPhamEntity.getGiamGia();

        this.anhDaiDien = sanPhamEntity.getAnhDaiDien();
        this.gia = sanPhamEntity.getGia();

        this.thuongHieuEntity = sanPhamEntity.getThuongHieuEntity();
        this.loaiSanPham = sanPhamEntity.getLoaiSanPham();
        this.star = sanPhamEntity.getStar();

        this.binhLuans = sanPhamEntity.getBinhLuans();
        this.taiKhoanEntities = sanPhamEntity.getTaiKhoanEntities();

        this.imgBase64 = imgBase64;
        this.fileTail = fileTail;
    }

    // lấy sản phẩm để làm danh mục
    public SanPhamDTO(SanPhamEntity sanPhamEntity){
        this.id = sanPhamEntity.getId();
        this.tenSanPham = sanPhamEntity.getTenSanPham();
    }
}
