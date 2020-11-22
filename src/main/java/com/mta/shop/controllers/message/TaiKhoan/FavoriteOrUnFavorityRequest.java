package com.mta.shop.controllers.message.TaiKhoan;

import lombok.Data;

@Data
public class FavoriteOrUnFavorityRequest {
    private String tenDangNhap;
    private Integer idSanPham;
}
