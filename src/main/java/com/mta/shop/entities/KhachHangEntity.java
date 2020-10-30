package com.mta.shop.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "KHACHHANG")
public class KhachHangEntity {
    private int id;
    private String maKhachHang;
    private String tenKhachHang;
    private Date ngaySinh;
    private Boolean gioiTinh;
    private String diaChi;
    private String soDienThoai;
    private int idTaiKhoan;
    private String img;

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
    @Column(name = "MAKHACHHANG")
    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    @Basic
    @Column(name = "TENKHACHHANG")
    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    @Basic
    @Column(name = "NGAYSINH")
    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    @Basic
    @Column(name = "GIOITINH")
    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    @Basic
    @Column(name = "DIACHI")
    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
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

    @Basic
    @Column(name = "IMG")
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
