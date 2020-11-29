package com.mta.shop.controllers.message.khachhang;

import com.mta.shop.entities.KhachHangEntity;
import lombok.Data;

@Data
public class AddCustomerRequest {
    private KhachHangEntity khachHangEntity;
    private String imgBase64;
}
