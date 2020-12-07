package com.mta.shop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Table(name = "QUYENSUDUNG")
public class QuyenSuDungEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "MAQUYEN")
    private String maQuyen;

    @Column(name = "QUYEN")
    private String quyen;

    @ManyToMany(mappedBy = "quyenSuDungEntities", cascade = CascadeType.ALL)
    @JsonBackReference
    private Collection<TaiKhoanEntity> taiKhoanEntities;

}
