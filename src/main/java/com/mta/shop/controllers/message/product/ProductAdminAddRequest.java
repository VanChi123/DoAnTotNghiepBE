package com.mta.shop.controllers.message.product;

import com.mta.shop.entities.SanPhamEntity;
import lombok.Data;

import java.util.List;

@Data
public class ProductAdminAddRequest {
    private SanPhamEntity sanPhamEntity;
    private String imgBase64;
    private String fileName;
    private String fileTail;
}
