package com.mta.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "NHANVIEN")
public class NhanVienEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id; // Integer thì mới set được nulll nhé

    @Column(name = "TENNHANVIEN")
    private String tenNhanVien;

    @Column(name = "MANHANVIEN")
    private String maNhanVien;

    @Column(name = "SODIENTHOAI")
    private String soDienThoai;

    @Column(name = "IDTAIKHOAN")
    private Integer idTaiKhoan;

}
