package com.mta.shop.controllers.message.hoadon;

import com.mta.shop.entities.GiamGia;
import com.mta.shop.entities.HoaDon;
import com.mta.shop.entities.SanPhamEntity;
import lombok.Data;

import javax.persistence.Column;
import java.sql.Timestamp;

@Data
public class HoaDonAddRequest {
  private HoaDon hoaDon;
}
