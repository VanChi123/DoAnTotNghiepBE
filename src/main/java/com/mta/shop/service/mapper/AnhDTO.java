package com.mta.shop.service.mapper;

import com.mta.shop.entities.ImagesEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnhDTO {
    private Integer id;
    private String tenAnh;
    private int idSanPham;
    private String imgBase64;

    public AnhDTO(ImagesEntity imagesEntity, String imgBase64){
        this.id = imagesEntity.getId();
        this.tenAnh = imagesEntity.getTenAnh();
        this.idSanPham = imagesEntity.getIdSanPham();
        this.imgBase64 = imgBase64;
    }
}
