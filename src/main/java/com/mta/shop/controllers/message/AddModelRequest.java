package com.mta.shop.controllers.message;

import com.mta.shop.entities.ThuongHieuEntity;
import lombok.Data;

@Data
public class AddModelRequest {
    private ThuongHieuEntity newThuongHieu;
}
