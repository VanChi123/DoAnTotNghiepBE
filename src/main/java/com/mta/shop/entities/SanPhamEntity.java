package com.mta.shop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Table(name = "SANPHAM")
@Entity // Đánh dấu đây là table trong db
@Data //get, set, toString v.v.
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamEntity {
//    private int id;
//    private String maSanPham;
//    private String tenSanPham;
//    private BigDecimal gia;
//    private String doiTuongSuDung;
//    private BigDecimal kichThuocBeMat;
//    private String chatLieuMatKinh;
//    private String chatLieuDay;
//    private BigDecimal doDay;
//    private BigDecimal doDai;
//    private BigDecimal doRongCuaDay;
//    private String kieuKhoa;
//    private String chatLieuVoMay;
//    private String may;
//    private String khaNangChiuNuoc;
//    private Integer giamGia;
//    private String img;
//    private Date ngayCapNhap;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "MASANPHAM")
    private String maSanPham;

    @Column(name = "TENSANPHAM")
    private String tenSanPham;


//    @Column(name = "IDLOAISANPHAM")
//    private int idLoaiSanPham;
    @Column(name = "GIA")
    private Float gia;

    @Column(name = "GIAMGIA")
    private Integer giamGia;

    @Column(name = "ANHDAIDIEN")
    private String anhDaiDien;

//    public LoaiSanPham getLoaiSanPham() {
//        return loaiSanPham;
//    }
//
//    public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
//        this.loaiSanPham = loaiSanPham;
//    }

//    @ManyToOne(fetch = FetchType.LAZY, targetEntity = LoaiSanPham.class)
//    @JoinColumn(name = "IDLOAISANPHAM",insertable = false,updatable = false)
//    @JsonBackReference
//    @JsonIgnore
//    private LoaiSanPham loaiSanPham;
//


    @ManyToOne
    @JoinColumn(name = "IDLOAISANPHAM", insertable = true, updatable = false)
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @JsonBackReference
//    @JsonIgnore

//    @JsonIgnore
//    @JsonManagedReference
    private LoaiSanPham loaiSanPham;

    @ManyToOne
    @JoinColumn(name = "IDTHUONGHIEU", insertable = true, updatable = true) // phải set thằng này ko update hay thêm mới nó ko sét giá trị cho đâu
    private ThuongHieuEntity thuongHieuEntity;

    @ManyToOne
    @JoinColumn(name = "IDSTAR", insertable = true, updatable = true) // phải set thằng này ko update hay thêm mới nó ko sét giá trị cho đâu
    private Star star;

    @OneToMany(mappedBy = "sanPham", cascade = CascadeType.ALL) // Quan hệ 1-n với đối tượng ở dưới (Person) (1 địa điểm có nhiều người ở)
    private Collection<BinhLuan> binhLuans;

    // mappring với tài khoản :favorite
//    @ManyToMany(mappedBy = "sanPhamEntities")
    @ManyToMany
    @JoinTable(
            name = "FAVORITE",
            joinColumns = {@JoinColumn(name = "IDSANPHAM", insertable = true, updatable = true)},
            inverseJoinColumns = {@JoinColumn(name = "IDTAIKHOAN", insertable = true, updatable = true)})
//    @JsonIgnore
    private List<TaiKhoanEntity> taiKhoanEntities;

    @OneToMany(mappedBy = "sanPhamEntity", cascade = CascadeType.ALL) // Quan hệ 1-n với đối tượng ở dưới (Person) (1 địa điểm có nhiều người ở)
    private Collection<ChiTietSanPham> chiTietSanPhams;

    @OneToMany(mappedBy = "sanPhamEntity", cascade = CascadeType.ALL) // Quan hệ 1-n với đối tượng ở dưới (Person) (1 địa điểm có nhiều người ở)
    @JsonBackReference
    private Collection<GioHang> gioHangs;

//    @OneToMany(mappedBy = "sanPhamEntity", fetch = FetchType.LAZY)
//    @JsonIgnore
//    private List<ChiTietPhieuNhap> chiTietPhieuNhapList;

    @Override
    public String toString() {
        return "SanPhamEntity{" +
                "id=" + id +
                ", maSanPham='" + maSanPham + '\'' +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", gia=" + gia +
                ", giamGia=" + giamGia +
                ", anhDaiDien='" + anhDaiDien + '\'' +
                '}';
    }
}
