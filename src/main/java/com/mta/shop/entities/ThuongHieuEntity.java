package com.mta.shop.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "THUONGHIEU")
public class ThuongHieuEntity {
    private int id;
    private String maThuongHieu;
    private String tenThuongHieu;
    private String thongTinThuongHieu;
    private String moTa;

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
    @Column(name = "MATHUONGHIEU")
    public String getMaThuongHieu() {
        return maThuongHieu;
    }

    public void setMaThuongHieu(String maThuongHieu) {
        this.maThuongHieu = maThuongHieu;
    }

    @Basic
    @Column(name = "TENTHUONGHIEU")
    public String getTenThuongHieu() {
        return tenThuongHieu;
    }

    public void setTenThuongHieu(String tenThuongHieu) {
        this.tenThuongHieu = tenThuongHieu;
    }

    @Basic
    @Column(name = "THONGTINTHUONGHIEU")
    public String getThongTinThuongHieu() {
        return thongTinThuongHieu;
    }

    public void setThongTinThuongHieu(String thongTinThuongHieu) {
        this.thongTinThuongHieu = thongTinThuongHieu;
    }

    @Basic
    @Column(name = "MOTA")
    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThuongHieuEntity that = (ThuongHieuEntity) o;
        return id == that.id &&
                Objects.equals(maThuongHieu, that.maThuongHieu) &&
                Objects.equals(tenThuongHieu, that.tenThuongHieu) &&
                Objects.equals(thongTinThuongHieu, that.thongTinThuongHieu) &&
                Objects.equals(moTa, that.moTa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, maThuongHieu, tenThuongHieu, thongTinThuongHieu, moTa);
    }
}
