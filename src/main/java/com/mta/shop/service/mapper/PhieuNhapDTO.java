package com.mta.shop.service.mapper;

import com.mta.shop.entities.PhieuNhap;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhieuNhapDTO {
    private Integer id;
    private String soPhieuNhap;

    public PhieuNhapDTO(PhieuNhap phieuNhap){
        this.id = phieuNhap.getId();
        this.soPhieuNhap = phieuNhap.getSoPhieuNhap();
    }
}
