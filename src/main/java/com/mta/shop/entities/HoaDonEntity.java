package com.mta.shop.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "HOADON")
public class HoaDonEntity {
    private int id;
    private Timestamp ngayTao;
    private BigDecimal tongTien;
    private BigDecimal tongTienPhaiTra;
    private Integer phanTramGiamGia;
    private BigDecimal tienGiamGia;

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
    @Column(name = "NGAYTAO")
    public Timestamp getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Timestamp ngayTao) {
        this.ngayTao = ngayTao;
    }

    @Basic
    @Column(name = "TONGTIEN")
    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    @Basic
    @Column(name = "TONGTIENPHAITRA")
    public BigDecimal getTongTienPhaiTra() {
        return tongTienPhaiTra;
    }

    public void setTongTienPhaiTra(BigDecimal tongTienPhaiTra) {
        this.tongTienPhaiTra = tongTienPhaiTra;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HoaDonEntity that = (HoaDonEntity) o;
        return id == that.id &&
                Objects.equals(ngayTao, that.ngayTao) &&
                Objects.equals(tongTien, that.tongTien) &&
                Objects.equals(tongTienPhaiTra, that.tongTienPhaiTra) &&
                Objects.equals(phanTramGiamGia, that.phanTramGiamGia) &&
                Objects.equals(tienGiamGia, that.tienGiamGia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ngayTao, tongTien, tongTienPhaiTra, phanTramGiamGia, tienGiamGia);
    }
}
