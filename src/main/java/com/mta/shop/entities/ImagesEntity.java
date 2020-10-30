package com.mta.shop.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "IMAGES")
public class ImagesEntity {
    private int id;
    private String tenAnh;
    private int idSanPham;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "TENANH")
    public String getTenAnh() {
        return tenAnh;
    }

    public void setTenAnh(String tenAnh) {
        this.tenAnh = tenAnh;
    }

    @Basic
    @Column(name = "IDSANPHAM")
    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImagesEntity that = (ImagesEntity) o;
        return id == that.id &&
                Objects.equals(tenAnh, that.tenAnh);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tenAnh);
    }
}
