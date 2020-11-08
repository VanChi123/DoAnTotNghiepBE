package com.mta.shop.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

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

}
