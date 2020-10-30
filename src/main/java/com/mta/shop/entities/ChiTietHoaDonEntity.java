package com.mta.shop.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "CHITIETHOADON")
@IdClass(ChiTietHoaDonEntityPK.class)
public class ChiTietHoaDonEntity {
    private int idSanPham;
    private int idHoaDon;
    private Integer soLuong;
    private BigDecimal gia;
    private Integer phanTramGiamGia;
    private BigDecimal tienGiamGia;
    private BigDecimal thanhTienSauGiamGia;

    @Id
    @Column(name = "IDSANPHAM")
    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    @Id
    @Column(name = "IDHOADON")
    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    @Basic
    @Column(name = "SOLUONG")
    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
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
    @Column(name = "PHANTRAMGIAMGIA")
    public Integer getPhanTramGiamGia() {
        return phanTramGiamGia;
    }

    public void setPhanTramGiamGia(Integer phanTramGiamGia) {
        this.phanTramGiamGia = phanTramGiamGia;
    }

    @Basic
    @Column(name = "TIENGIAMGIA")
    public BigDecimal getTienGiamGia() {
        return tienGiamGia;
    }

    public void setTienGiamGia(BigDecimal tienGiamGia) {
        this.tienGiamGia = tienGiamGia;
    }

    @Basic
    @Column(name = "THANHTIENSAUGIAMGIA")
    public BigDecimal getThanhTienSauGiamGia() {
        return thanhTienSauGiamGia;
    }

    public void setThanhTienSauGiamGia(BigDecimal thanhTienSauGiamGia) {
        this.thanhTienSauGiamGia = thanhTienSauGiamGia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChiTietHoaDonEntity that = (ChiTietHoaDonEntity) o;
        return idSanPham == that.idSanPham &&
                idHoaDon == that.idHoaDon &&
                Objects.equals(soLuong, that.soLuong) &&
                Objects.equals(gia, that.gia) &&
                Objects.equals(phanTramGiamGia, that.phanTramGiamGia) &&
                Objects.equals(tienGiamGia, that.tienGiamGia) &&
                Objects.equals(thanhTienSauGiamGia, that.thanhTienSauGiamGia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSanPham, idHoaDon, soLuong, gia, phanTramGiamGia, tienGiamGia, thanhTienSauGiamGia);
    }
}
