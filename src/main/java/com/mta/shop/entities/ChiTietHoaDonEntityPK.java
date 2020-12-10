package com.mta.shop.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ChiTietHoaDonEntityPK implements Serializable {
    @Column(name = "IDSANPHAM")
    private int idSanPham;

    @Column(name = "IDHOADON")
    private int idHoaDon;

}
