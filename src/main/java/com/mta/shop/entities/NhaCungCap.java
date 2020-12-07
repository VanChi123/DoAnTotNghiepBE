package com.mta.shop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.Collection;

@Table(name = "NHACUNGCAP")
@Entity // Đánh dấu đây là table trong db
@Data // lombok giúp generate các hàm constructor, get, set v.v.
@AllArgsConstructor
@NoArgsConstructor
public class NhaCungCap {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name = "ID")
        private Integer id;

        @Column(name = "MANCC")
        private String maNCC;

        @Column(name = "TENNCC")
        private String tenNCC;

        @Column(name = "DIACHI")
        private String diaChi;

        @Column(name = "SODIENTHOAI")
        private String soDienThoai;

        @Column(name = "EMAIL")
        private String email;

        @Column(name = "WEBSITE")
        private String website;

        @OneToMany(mappedBy = "nhaCungCap", cascade = CascadeType.ALL) // Quan hệ 1-n với đối tượng ở dưới (Person) (1 địa điểm có nhiều người ở)
        @JsonBackReference
        private Collection<PhieuNhap> phieuNhaps;

//        @ManyToOne
//        @JsonBackReference
//        @JoinColumn(name = "IDSANPHAM", insertable = true, updatable = true) // phải set thằng này ko update hay thêm mới nó ko sét giá trị cho đâu
//        private SanPhamEntity sanPham;

//        @ManyToOne
//        @JoinColumn(name = "IDTAIKHOAN", insertable = true, updatable = true) // phải set thằng này ko update hay thêm mới nó ko sét giá trị cho đâu
//        private TaiKhoanEntity taiKhoan;

}
