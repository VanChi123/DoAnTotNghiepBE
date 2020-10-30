package com.mta.shop.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "NHANVIEN")
public class NhanVienEntity {
    private int id;
    private String tenNhanVien;
    private String maNhanVien;
    private String soDienThoai;
    private int idTaiKhoan;

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
    @Column(name = "TENNHANVIEN")
    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    @Basic
    @Column(name = "MANHANVIEN")
    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    @Basic
    @Column(name = "SODIENTHOAI")
    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    @Basic
    @Column(name = "IDTAIKHOAN")
    public int getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(int idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NhanVienEntity that = (NhanVienEntity) o;
        return id == that.id &&
                Objects.equals(tenNhanVien, that.tenNhanVien) &&
                Objects.equals(maNhanVien, that.maNhanVien) &&
                Objects.equals(soDienThoai, that.soDienThoai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tenNhanVien, maNhanVien, soDienThoai);
    }
}
