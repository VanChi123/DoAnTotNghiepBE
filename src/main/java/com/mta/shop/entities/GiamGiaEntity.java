package com.mta.shop.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "GIAMGIA")
public class GiamGiaEntity {
    private int id;
    private String moTa;
    private Integer tiLeGiam;

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
    @Column(name = "MOTA")
    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Basic
    @Column(name = "TILEGIAM")
    public Integer getTiLeGiam() {
        return tiLeGiam;
    }

    public void setTiLeGiam(Integer tiLeGiam) {
        this.tiLeGiam = tiLeGiam;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GiamGiaEntity that = (GiamGiaEntity) o;
        return id == that.id &&
                Objects.equals(moTa, that.moTa) &&
                Objects.equals(tiLeGiam, that.tiLeGiam);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, moTa, tiLeGiam);
    }
}
