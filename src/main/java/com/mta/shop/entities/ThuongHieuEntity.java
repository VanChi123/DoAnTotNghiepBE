package com.mta.shop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "THUONGHIEU")
public class ThuongHieuEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "MATHUONGHIEU")
    private String maThuongHieu;

    @Column(name = "TENTHUONGHIEU")
    private String tenThuongHieu;

    @Column(name = "THONGTINTHUONGHIEU")
    private String thongTinThuongHieu;

    @Column(name = "MOTA")
    private String moTa;

    @OneToMany(mappedBy = "thuongHieuEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // Quan hệ 1-n với đối tượng ở dưới (Person) (1 địa điểm có nhiều người ở)
    @JsonBackReference
    private Collection<SanPhamEntity> sanPhamEntities;

}
