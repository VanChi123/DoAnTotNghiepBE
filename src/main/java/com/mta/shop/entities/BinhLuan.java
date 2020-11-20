package com.mta.shop.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;

@Table(name = "BINHLUAN")
@Entity // Đánh dấu đây là table trong db
@Data // lombok giúp generate các hàm constructor, get, set v.v.
@AllArgsConstructor
@NoArgsConstructor
public class BinhLuan {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name = "ID")
        private Integer id;

        @Column(name = "NGAYGIO")
        private Instant ngayGio;

        @Column(name = "NOIDUNG")
        private String noiDung;

        @Column(name = "TENKHACHHANG")
        private String tenKhachHang;

        @Column(name = "SODIENTHOAI")
        private String soDienThoai;


        @ManyToOne
        @JsonBackReference
        @JoinColumn(name = "IDSANPHAM", insertable = true, updatable = true) // phải set thằng này ko update hay thêm mới nó ko sét giá trị cho đâu
        private SanPhamEntity sanPham;

        @ManyToOne
        @JoinColumn(name = "IDTAIKHOAN", insertable = true, updatable = true) // phải set thằng này ko update hay thêm mới nó ko sét giá trị cho đâu
        private TaiKhoanEntity taiKhoan;

}
