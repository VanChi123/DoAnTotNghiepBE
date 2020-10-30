package com.mta.shop.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "TAIKHOAN")
public class TaiKhoanEntity {
    private int id;
    private String tenDangNhap;
    private String matKhau;
    private String email;

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
    @Column(name = "TENDANGNHAP")
    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    @Basic
    @Column(name = "MATKHAU")
    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    @Basic
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TaiKhoanEntity(){

    }

    public TaiKhoanEntity( String tenDangNhap,  String matKhau,  String email){
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaiKhoanEntity that = (TaiKhoanEntity) o;
        return id == that.id &&
                Objects.equals(tenDangNhap, that.tenDangNhap) &&
                Objects.equals(matKhau, that.matKhau) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tenDangNhap, matKhau, email);
    }
}
