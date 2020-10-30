package com.mta.shop.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "SANPHAM")
public class SanPhamEntity {
    private int id;
    private String maSanPham;
    private String tenSanPham;
    private BigDecimal gia;
    private String doiTuongSuDung;
    private BigDecimal kichThuocBeMat;
    private String chatLieuMatKinh;
    private String chatLieuDay;
    private BigDecimal doDay;
    private BigDecimal doDai;
    private BigDecimal doRongCuaDay;
    private String kieuKhoa;
    private String chatLieuVoMay;
    private String may;
    private String khaNangChiuNuoc;
    private Integer giamGia;
    private String img;
    private Date ngayCapNhap;

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
    @Column(name = "MASANPHAM")
    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    @Basic
    @Column(name = "TENSANPHAM")
    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    @Basic
    @Column(name = "GIA")
    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    @Basic
    @Column(name = "DOITUONGSUDUNG")
    public String getDoiTuongSuDung() {
        return doiTuongSuDung;
    }

    public void setDoiTuongSuDung(String doiTuongSuDung) {
        this.doiTuongSuDung = doiTuongSuDung;
    }

    @Basic
    @Column(name = "KICHTHUOCBEMAT")
    public BigDecimal getKichThuocBeMat() {
        return kichThuocBeMat;
    }

    public void setKichThuocBeMat(BigDecimal kichThuocBeMat) {
        this.kichThuocBeMat = kichThuocBeMat;
    }

    @Basic
    @Column(name = "CHATLIEUMATKINH")
    public String getChatLieuMatKinh() {
        return chatLieuMatKinh;
    }

    public void setChatLieuMatKinh(String chatLieuMatKinh) {
        this.chatLieuMatKinh = chatLieuMatKinh;
    }

    @Basic
    @Column(name = "CHATLIEUDAY")
    public String getChatLieuDay() {
        return chatLieuDay;
    }

    public void setChatLieuDay(String chatLieuDay) {
        this.chatLieuDay = chatLieuDay;
    }

    @Basic
    @Column(name = "DODAY")
    public BigDecimal getDoDay() {
        return doDay;
    }

    public void setDoDay(BigDecimal doDay) {
        this.doDay = doDay;
    }

    @Basic
    @Column(name = "DODAI")
    public BigDecimal getDoDai() {
        return doDai;
    }

    public void setDoDai(BigDecimal doDai) {
        this.doDai = doDai;
    }

    @Basic
    @Column(name = "DORONGCUADAY")
    public BigDecimal getDoRongCuaDay() {
        return doRongCuaDay;
    }

    public void setDoRongCuaDay(BigDecimal doRongCuaDay) {
        this.doRongCuaDay = doRongCuaDay;
    }

    @Basic
    @Column(name = "KIEUKHOA")
    public String getKieuKhoa() {
        return kieuKhoa;
    }

    public void setKieuKhoa(String kieuKhoa) {
        this.kieuKhoa = kieuKhoa;
    }

    @Basic
    @Column(name = "CHATLIEUVOMAY")
    public String getChatLieuVoMay() {
        return chatLieuVoMay;
    }

    public void setChatLieuVoMay(String chatLieuVoMay) {
        this.chatLieuVoMay = chatLieuVoMay;
    }

    @Basic
    @Column(name = "MAY")
    public String getMay() {
        return may;
    }

    public void setMay(String may) {
        this.may = may;
    }

    @Basic
    @Column(name = "KHANANGCHIUNUOC")
    public String getKhaNangChiuNuoc() {
        return khaNangChiuNuoc;
    }

    public void setKhaNangChiuNuoc(String khaNangChiuNuoc) {
        this.khaNangChiuNuoc = khaNangChiuNuoc;
    }

    @Basic
    @Column(name = "GIAMGIA")
    public Integer getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(Integer giamGia) {
        this.giamGia = giamGia;
    }

    @Basic
    @Column(name = "IMG")
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Basic
    @Column(name = "NGAYCAPNHAP")
    public Date getNgayCapNhap() {
        return ngayCapNhap;
    }

    public void setNgayCapNhap(Date ngayCapNhap) {
        this.ngayCapNhap = ngayCapNhap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SanPhamEntity that = (SanPhamEntity) o;
        return id == that.id &&
                Objects.equals(maSanPham, that.maSanPham) &&
                Objects.equals(tenSanPham, that.tenSanPham) &&
                Objects.equals(gia, that.gia) &&
                Objects.equals(doiTuongSuDung, that.doiTuongSuDung) &&
                Objects.equals(kichThuocBeMat, that.kichThuocBeMat) &&
                Objects.equals(chatLieuMatKinh, that.chatLieuMatKinh) &&
                Objects.equals(chatLieuDay, that.chatLieuDay) &&
                Objects.equals(doDay, that.doDay) &&
                Objects.equals(doDai, that.doDai) &&
                Objects.equals(doRongCuaDay, that.doRongCuaDay) &&
                Objects.equals(kieuKhoa, that.kieuKhoa) &&
                Objects.equals(chatLieuVoMay, that.chatLieuVoMay) &&
                Objects.equals(may, that.may) &&
                Objects.equals(khaNangChiuNuoc, that.khaNangChiuNuoc) &&
                Objects.equals(giamGia, that.giamGia) &&
                Objects.equals(img, that.img) &&
                Objects.equals(ngayCapNhap, that.ngayCapNhap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, maSanPham, tenSanPham, gia, doiTuongSuDung, kichThuocBeMat, chatLieuMatKinh, chatLieuDay, doDay, doDai, doRongCuaDay, kieuKhoa, chatLieuVoMay, may, khaNangChiuNuoc, giamGia, img, ngayCapNhap);
    }
}
