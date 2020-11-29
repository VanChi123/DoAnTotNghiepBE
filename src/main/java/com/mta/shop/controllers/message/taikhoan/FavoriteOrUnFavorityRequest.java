package com.mta.shop.controllers.message.taikhoan;

import lombok.Data;

@Data
public class FavoriteOrUnFavorityRequest {
    private String tenDangNhap;
    private Integer idSanPham;
}
