package com.mta.shop.entities;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "CHITIETHOADON")
public class ChiTietHoaDonEntity {
    @EmbeddedId
    private ChiTietHoaDonEntityPK chiTietHoaDonEntityPK;

    @Column(name = "SOLUONG")
    private Integer soLuong;

    @Column(name = "GIA")
    private BigDecimal gia;

    @Column(name = "PHANTRAMGIAMGIA")
    private Integer phanTramGiamGia;

    @Column(name = "TIENGIAMGIA")
    private BigDecimal tienGiamGia;

    @Column(name = "THANHTIENSAUGIAMGIA")
    private BigDecimal thanhTienSauGiamGia;

    @Column(name = "THANHTIEN")
    private BigDecimal thanhTien;

    @ManyToOne
    @JoinColumn(name = "IDSANPHAM", insertable = false, updatable = false) // phải set thằng này ko update hay thêm mới nó ko sét giá trị cho đâu
    private SanPhamEntity sanPhamEntity;

    @ManyToOne
    @JoinColumn(name = "IDHOADON", insertable = false, updatable = false) // phải set thằng này ko update hay thêm mới nó ko sét giá trị cho đâu
    private HoaDon hoaDon;

}
