package com.mta.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Table(name = "CHITIETPHIEUNHAP")
@Entity // Đánh dấu đây là table trong db
@Data // lombok giúp generate các hàm constructor, get, set v.v.
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietPhieuNhap {
        @EmbeddedId
        private ChiTietPhieuNhapPK chiTietPhieuNhapPK;



        @Column(name = "SOLUONGNHAP")
        private Integer soLuongNhap;

        @Column(name = "GIANHAP")
        private Float giaNhap;

        @Column(name = "THANHTIEN")
        private Float thanhTien;

        @Override
        public String toString() {
                return "ChiTietPhieuNhap{" +
                        ", soLuongNhap=" + soLuongNhap +
                        ", giaNhap=" + giaNhap +
                        ", thanhTien=" + thanhTien +
                        '}';
        }
}
