package com.mta.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity // Đánh dấu đây là table trong db
@Data // lombok giúp generate các hàm constructor, get, set v.v.
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "HOADON")
public class HoaDon {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NGAYTAO")
    private Timestamp ngayTao;

    @Column(name = "TONGTIEN")
    private Float tongTien;

    @Column(name = "TONGTIENPHAITRA")
    private Float tongTienPhaiTra;

    @Column(name = "PHANTRAMGIAMGIA")
    private Integer phanTramGiamGia;

    @Column(name = "TIENGIAMGIA")
    private Float tienGiamGia;

    @Column(name = "MAHOADON")
    private String maHoaDon;

    @Column(name = "TRANGTHAI")
    private Integer trangThai;

    @Column(name = "HINHTHUCTHANHTOAN")
    private Integer hinhThucThanhToan;

    @Column(name = "SOTIENDATRA")
    private Float soTienDaTra;


    @Column(name = "IDGIAMGIA")
    private Integer idGiamGia;

    @Column(name = "IDKHACHHANG")
    private Integer idKhachHang;

    @Column(name = "IDNHANVIEN")
    private Integer idNhanVien;

//    @ManyToOne
//    @JoinColumn(name = "IDGIAMGIA", insertable = false, updatable = false) // phải set thằng này ko update hay thêm mới nó ko sét giá trị cho đâu
//    private GiamGia giamGiaJoin;

}
