package com.mta.shop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

//@Entity
@Table(name = "PHIEUNHAP")
@Entity // Đánh dấu đây là table trong db
@Data // lombok giúp generate các hàm constructor, get, set v.v.
@AllArgsConstructor
@NoArgsConstructor
public class PhieuNhap {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name = "ID")
        private Integer id;

        @Column(name = "SOPHIEUNHAP")
        private String soPhieuNhap;

        @Column(name = "NGAYNHAP")
        private Date ngayNhap;

        @Column(name = "TONGTIEN")
        private Float tongTien;

        @ManyToOne
        @JoinColumn(name = "IDNCC", insertable = true, updatable = true) // phải set thằng này ko update hay thêm mới nó ko sét giá trị cho đâu
        private NhaCungCap nhaCungCap;

        @ManyToOne
        @JoinColumn(name = "IDNHANVIEN", insertable = true, updatable = true) // phải set thằng này ko update hay thêm mới nó ko sét giá trị cho đâu
        private NhanVienEntity nhanVienEntity;


//    @OneToMany(mappedBy = "phieuNhap", fetch = FetchType.LAZY)
//    @JsonManagedReference
//    private List<ChiTietPhieuNhap> chiTietPhieuNhapList;


//        @OneToMany(mappedBy = "loaiSanPham", cascade = CascadeType.ALL) // Quan hệ 1-n với đối tượng ở dưới (Person) (1 địa điểm có nhiều người ở)
//        @JsonBackReference
//        private Collection<SanPhamEntity> persons;

}
