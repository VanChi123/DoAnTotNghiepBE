package com.mta.shop.controllers.message;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateInformationCustomerRequest {
    private int id;
    private String maKhachHang;
    private String tenKhachHang;
    private Date ngaySinh;
    private Boolean gioiTinh;
    private String diaChi;
    private String soDienThoai;
    private int idTaiKhoan;
    private String img;

    private String imgBase64;
    private String fileTail;
    private String filePathOld;

}
