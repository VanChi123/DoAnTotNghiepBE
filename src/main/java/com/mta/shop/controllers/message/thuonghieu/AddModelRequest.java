package com.mta.shop.controllers.message.thuonghieu;

import com.mta.shop.entities.ThuongHieuEntity;
import lombok.Data;

@Data
public class AddModelRequest {
    private ThuongHieuEntity newThuongHieu;
}
