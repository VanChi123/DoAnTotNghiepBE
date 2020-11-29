package com.mta.shop.controllers.message.taikhoan;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAccountListRequest {

    private int pageNumber;
    private int pageSize;
    private String tenDangNhap;
    private String email;
    private List<Integer> quyenSuDung;
//    private String createdDate;
//    private String lastModifiedDate;
}

