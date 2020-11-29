package com.mta.shop.controllers.message.loaisanpham;

import com.mta.shop.entities.LoaiSanPham;
import com.mta.shop.entities.ThuongHieuEntity;
import lombok.Data;

@Data
public class AddCategoryRequest {
    private LoaiSanPham loaiSanPham;
}
