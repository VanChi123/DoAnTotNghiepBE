package com.mta.shop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "GIA")
    private Float gia;

    @Column(name = "DOITUONGSUDUNG")
    private String doiTuongSuDung;

    @Column(name = "KICHTHUOCBEMAT")
    private Float kichThuocBeMat;

//    @Column(name = "IDLOAISANPHAM")
//    private int idLoaiSanPham;


    @Column(name = "CHATLIEUMATKINH")
    private String chatLieuMatKinh;


    @Column(name = "CHATLIEUDAY")
    private String chatLieuDay;

    @Column(name = "DODAY")
    private Float doDay;

    @Column(name = "DODAI")
    private Float doDai;

    @Column(name = "DORONGCUADAY")
    private Float doRongCuaDay;

    @Column(name = "KIEUKHOA")
    private String kieuKhoa;

    @Column(name = "CHATLIEUVOMAY")
    private String chatLieuVoMay;

    @Column(name = "MAY")
    private String may;

    @Column(name = "KHANANGCHIUNUOC")
    private String khaNangChiuNuoc;

    @Column(name = "GIAMGIA")
    private Integer giamGia;

    @Column(name = "IMG")
    private String img;

    @Column(name = "NGAYCAPNHAP")
    private Date ngayCapNhap;

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

    @Override
    public String toString() {
        return "SanPhamEntity{" +
                "id=" + id +
                ", maSanPham='" + maSanPham + '\'' +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", gia=" + gia +
                ", doiTuongSuDung='" + doiTuongSuDung + '\'' +
                ", kichThuocBeMat=" + kichThuocBeMat +
                ", chatLieuMatKinh='" + chatLieuMatKinh + '\'' +
                ", chatLieuDay='" + chatLieuDay + '\'' +
                ", doDay=" + doDay +
                ", doDai=" + doDai +
                ", doRongCuaDay=" + doRongCuaDay +
                ", kieuKhoa='" + kieuKhoa + '\'' +
                ", chatLieuVoMay='" + chatLieuVoMay + '\'' +
                ", may='" + may + '\'' +
                ", khaNangChiuNuoc='" + khaNangChiuNuoc + '\'' +
                ", giamGia=" + giamGia +
                ", img='" + img + '\'' +
                ", ngayCapNhap=" + ngayCapNhap +
                '}';
    }
}
