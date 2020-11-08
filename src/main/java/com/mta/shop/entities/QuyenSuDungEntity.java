package com.mta.shop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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

    @ManyToMany(mappedBy = "quyenSuDungEntities", cascade = CascadeType.ALL)
    @JsonBackReference
    private Collection<TaiKhoanEntity> taiKhoanEntities;

//    @Getter
//    @Setter
//    @ManyToMany
//    Set<TaiKhoanEntity> taiKhoanEntitySet;

//    @Getter
//    @Setter
    //@ManyToMany(mappedBy = "quyenSuDungEntitySet", fetch = FetchType.EAGER)
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "PHANQUYEN",
//            joinColumns = @JoinColumn(name = "IDQUYEN"),
//            inverseJoinColumns = @JoinColumn(name = "IDTAIKHOAN"))


//@ManyToMany
//@JoinTable(
//        name = "PHANQUYEN",
//        joinColumns = {@JoinColumn(name = "IDQUYEN")},
//        inverseJoinColumns = {@JoinColumn(name = "IDTAIKHOAN")})


//    @JoinTable(name = "PHANQUYEN",
//            joinColumns = { @JoinColumn(name = "IDTAIKHOAN") },
//            inverseJoinColumns = {@JoinColumn(name = "IDQUYEN") })

//    @Getter
//    @Setter
//    @ElementCollection


//    Set<QuyenSuDungEntity> quyenSuDungEntitySet = new HashSet<>();
//
//    public Set<QuyenSuDungEntity> getQuyenSuDungEntitySet() {
//        return quyenSuDungEntitySet;
//    }
//
//    public void setQuyenSuDungEntitySet(Set<QuyenSuDungEntity> quyenSuDungEntitySet) {
//        this.quyenSuDungEntitySet = quyenSuDungEntitySet;
//    }

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
