package com.mta.shop.controllers.message.hoadon;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class HoaDonUpdatePaymentRequest {
    private int id;
    private Integer hinhThucThanhToan; // 0 là tiền mặt, 1 là thanh toán qua thẻ
    private Float soTienDaTra;
    private Integer trangThai; // 0 là chưa / 1 là đã thanh toán
}
