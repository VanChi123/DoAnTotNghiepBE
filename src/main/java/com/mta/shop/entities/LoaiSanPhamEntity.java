package com.mta.shop.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "LOAISANPHAM")
public class LoaiSanPhamEntity {
    private int id;
    private String tenLoaiSanPham;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TENLOAISANPHAM")
    public String getTenLoaiSanPham() {
        return tenLoaiSanPham;
    }

    public void setTenLoaiSanPham(String tenLoaiSanPham) {
        this.tenLoaiSanPham = tenLoaiSanPham;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoaiSanPhamEntity that = (LoaiSanPhamEntity) o;
        return id == that.id &&
                Objects.equals(tenLoaiSanPham, that.tenLoaiSanPham);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tenLoaiSanPham);
    }
}
