package com.mta.shop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
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

//    @Column(name = "IDTAIKHOAN")
//    private Integer idTaiKhoan;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "IDTAIKHOAN", referencedColumnName = "ID")
//    private TaiKhoanEntity taiKhoanEntity;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "IDTAIKHOAN", insertable = true, updatable = true, nullable=true)
    private TaiKhoanEntity taiKhoanEntity;

    @OneToMany(mappedBy = "nhanVienEntity", cascade = CascadeType.ALL) // Quan hệ 1-n với đối tượng ở dưới (Person) (1 địa điểm có nhiều người ở)
    @JsonBackReference
    private Collection<PhieuNhap> phieuNhaps;

    @OneToMany(mappedBy = "khachHangEntity", cascade = CascadeType.ALL) // Quan hệ 1-n với đối tượng ở dưới (Person) (1 địa điểm có nhiều người ở)
    @JsonIgnore
    private Collection<HoaDon> hoaDons;
}
