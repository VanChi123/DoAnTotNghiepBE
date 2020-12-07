package com.mta.shop.service.mapper;

import com.mta.shop.entities.ImagesEntity;
import com.mta.shop.entities.NhanVienEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NhanVienDTO {
    private Integer id;
    private String tenNhanVien;

    public NhanVienDTO(NhanVienEntity nhanVienEntity){
        this.id = nhanVienEntity.getId();
        this.tenNhanVien = nhanVienEntity.getTenNhanVien();
    }
}
