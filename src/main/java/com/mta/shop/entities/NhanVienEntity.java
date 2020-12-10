package com.mta.shop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

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

//    @Column(name = "IDTAIKHOAN")
//    private Integer idTaiKhoan;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "IDTAIKHOAN", insertable = true, updatable = true, nullable=true)
    private TaiKhoanEntity taiKhoanEntity;

    @OneToMany(mappedBy = "nhaCungCap", cascade = CascadeType.ALL) // Quan hệ 1-n với đối tượng ở dưới (Person) (1 địa điểm có nhiều người ở)
    @JsonBackReference
    private Collection<PhieuNhap> phieuNhaps;

    @OneToMany(mappedBy = "nhanVienEntity", cascade = CascadeType.ALL) // Quan hệ 1-n với đối tượng ở dưới (Person) (1 địa điểm có nhiều người ở)
    @JsonIgnore
    private Collection<HoaDon> hoaDons;

}
