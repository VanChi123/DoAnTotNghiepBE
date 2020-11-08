package com.mta.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity // Đánh dấu đây là table trong db
@Data // lombok giúp generate các hàm constructor, get, set v.v.
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "KHACHHANG")
public class KhachHangEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "MAKHACHHANG")
    private String maKhachHang;


    @Column(name = "TENKHACHHANG")
    private String tenKhachHang;


    @Column(name = "NGAYSINH")
    private Date ngaySinh;


    @Column(name = "GIOITINH")
    private Boolean gioiTinh;


    @Column(name = "DIACHI")
    private String diaChi;

    @Column(name = "SODIENTHOAI")
    private String soDienThoai;

    @Column(name = "IMG")
    private String img;

    @Column(name = "IDTAIKHOAN")
    private Integer idTaiKhoan;;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "IDTAIKHOAN", referencedColumnName = "ID")
//    private TaiKhoanEntity taiKhoanEntity;
}
