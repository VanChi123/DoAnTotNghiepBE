package com.mta.shop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Table(name = "CHITIETSANPHAM")
@Entity // Đánh dấu đây là table trong db
@Data //get, set, toString v.v.
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietSanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DOITUONGSUDUNG")
    private String doiTuongSuDung;

    @Column(name = "KICHTHUOCBEMAT")
    private  Float kichThuocBeMat;

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

//    @Column(name = "NGAYCAPNHAT")
//    private Date ngayCapNhat;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "IDSANPHAM", insertable = true, updatable = true) // phải set thằng này ko update hay thêm mới nó ko sét giá trị cho đâu
    private SanPhamEntity sanPhamEntity;

    @Override
    public String toString() {
        return "ChiTietSanPham{" +
                "id=" + id +
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
//                ", ngayCapNhat=" + ngayCapNhat +
                '}';
    }
}
