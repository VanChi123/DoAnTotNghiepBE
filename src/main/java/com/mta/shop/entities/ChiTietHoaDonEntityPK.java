package com.mta.shop.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ChiTietHoaDonEntityPK implements Serializable {
    private int idSanPham;
    private int idHoaDon;

    @Column(name = "IDSANPHAM")
    @Id
    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    @Column(name = "IDHOADON")
    @Id
    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChiTietHoaDonEntityPK that = (ChiTietHoaDonEntityPK) o;
        return idSanPham == that.idSanPham &&
                idHoaDon == that.idHoaDon;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSanPham, idHoaDon);
    }
}
