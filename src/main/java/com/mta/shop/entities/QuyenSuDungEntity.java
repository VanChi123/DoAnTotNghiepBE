package com.mta.shop.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "QUYENSUDUNG")
public class QuyenSuDungEntity {
    private int id;
    private String quyen;

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
    @Column(name = "QUYEN")
    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuyenSuDungEntity that = (QuyenSuDungEntity) o;
        return id == that.id &&
                Objects.equals(quyen, that.quyen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quyen);
    }
}
