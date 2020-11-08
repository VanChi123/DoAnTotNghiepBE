package com.mta.shop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Table(name = "SANPHAM")
@Entity // Đánh dấu đây là table trong db
@Data // lombok giúp generate các hàm constructor, get, set v.v.
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamEntity {
//    private int id;
//    private String maSanPham;
//    private String tenSanPham;
//    private BigDecimal gia;
//    private String doiTuongSuDung;
//    private BigDecimal kichThuocBeMat;
//    private String chatLieuMatKinh;
//    private String chatLieuDay;
//    private BigDecimal doDay;
//    private BigDecimal doDai;
//    private BigDecimal doRongCuaDay;
//    private String kieuKhoa;
//    private String chatLieuVoMay;
//    private String may;
//    private String khaNangChiuNuoc;
//    private Integer giamGia;
//    private String img;
//    private Date ngayCapNhap;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "MASANPHAM")
    private String maSanPham;

    @Column(name = "TENSANPHAM")
    private String tenSanPham;

    @Column(name = "GIA")
    private float gia;

    @Column(name = "DOITUONGSUDUNG")
    private String doiTuongSuDung;

    @Column(name = "KICHTHUOCBEMAT")
    private float kichThuocBeMat;

//    @Column(name = "IDLOAISANPHAM")
//    private int idLoaiSanPham;

//    @Basic
//    @Column(name = "CHATLIEUMATKINH")
//    public String getChatLieuMatKinh() {
//        return chatLieuMatKinh;
//    }
//
//    public void setChatLieuMatKinh(String chatLieuMatKinh) {
//        this.chatLieuMatKinh = chatLieuMatKinh;
//    }
//
//    @Basic
//    @Column(name = "CHATLIEUDAY")
//    public String getChatLieuDay() {
//        return chatLieuDay;
//    }
//
//    public void setChatLieuDay(String chatLieuDay) {
//        this.chatLieuDay = chatLieuDay;
//    }
//
//    @Basic
//    @Column(name = "DODAY")
//    public BigDecimal getDoDay() {
//        return doDay;
//    }
//
//    public void setDoDay(BigDecimal doDay) {
//        this.doDay = doDay;
//    }
//
//    @Basic
//    @Column(name = "DODAI")
//    public BigDecimal getDoDai() {
//        return doDai;
//    }
//
//    public void setDoDai(BigDecimal doDai) {
//        this.doDai = doDai;
//    }
//
//    @Basic
//    @Column(name = "DORONGCUADAY")
//    public BigDecimal getDoRongCuaDay() {
//        return doRongCuaDay;
//    }
//
//    public void setDoRongCuaDay(BigDecimal doRongCuaDay) {
//        this.doRongCuaDay = doRongCuaDay;
//    }
//
//    @Basic
//    @Column(name = "KIEUKHOA")
//    public String getKieuKhoa() {
//        return kieuKhoa;
//    }
//
//    public void setKieuKhoa(String kieuKhoa) {
//        this.kieuKhoa = kieuKhoa;
//    }
//
//    @Basic
//    @Column(name = "CHATLIEUVOMAY")
//    public String getChatLieuVoMay() {
//        return chatLieuVoMay;
//    }
//
//    public void setChatLieuVoMay(String chatLieuVoMay) {
//        this.chatLieuVoMay = chatLieuVoMay;
//    }
//
//    @Basic
//    @Column(name = "MAY")
//    public String getMay() {
//        return may;
//    }
//
//    public void setMay(String may) {
//        this.may = may;
//    }
//
//    @Basic
//    @Column(name = "KHANANGCHIUNUOC")
//    public String getKhaNangChiuNuoc() {
//        return khaNangChiuNuoc;
//    }
//
//    public void setKhaNangChiuNuoc(String khaNangChiuNuoc) {
//        this.khaNangChiuNuoc = khaNangChiuNuoc;
//    }
//
//    @Basic
//    @Column(name = "GIAMGIA")
//    public Integer getGiamGia() {
//        return giamGia;
//    }
//
//    public void setGiamGia(Integer giamGia) {
//        this.giamGia = giamGia;
//    }
//
//    @Basic
//    @Column(name = "IMG")
//    public String getImg() {
//        return img;
//    }
//
//    public void setImg(String img) {
//        this.img = img;
//    }
//
//    @Basic
//    @Column(name = "NGAYCAPNHAP")
//    public Date getNgayCapNhap() {
//        return ngayCapNhap;
//    }
//
//    public void setNgayCapNhap(Date ngayCapNhap) {
//        this.ngayCapNhap = ngayCapNhap;
//    }
//
//    public LoaiSanPham getLoaiSanPham() {
//        return loaiSanPham;
//    }
//
//    public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
//        this.loaiSanPham = loaiSanPham;
//    }

//    @ManyToOne(fetch = FetchType.LAZY, targetEntity = LoaiSanPham.class)
//    @JoinColumn(name = "IDLOAISANPHAM",insertable = false,updatable = false)
//    @JsonBackReference
//    @JsonIgnore
//    private LoaiSanPham loaiSanPham;
//


    @ManyToOne
    @JoinColumn(name = "IDLOAISANPHAM", insertable = false,updatable = false)
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @JsonBackReference
//    @JsonIgnore

//    @JsonIgnore
//    @JsonManagedReference
    private LoaiSanPham loaiSanPham;

}
