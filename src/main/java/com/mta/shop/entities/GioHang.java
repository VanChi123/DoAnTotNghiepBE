package com.mta.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "GIOHANG")
public class GioHang {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id; // Integer thì mới set được nulll nhé

    @Column(name = "SOLUONG")
    private String soLuong;

    @Column(name = "TENSANPHAM")
    private String tenSanPham;

    @Column(name = "TENKHACHHANG")
    private String tenKhachHang;

    @Column(name = "IDCHITIETSANPHAM")
    private Integer idChiTietSanPham;

    @ManyToOne
    @JoinColumn(name = "IDKHACHHANG", insertable = true, updatable = true) // phải set thằng này ko update hay thêm mới nó ko sét giá trị cho đâu
    private KhachHangEntity khachHangEntity;

    @ManyToOne
    @JoinColumn(name = "IDSANPHAM", insertable = true, updatable = true) // phải set thằng này ko update hay thêm mới nó ko sét giá trị cho đâu
    private SanPhamEntity sanPhamEntity;




}
