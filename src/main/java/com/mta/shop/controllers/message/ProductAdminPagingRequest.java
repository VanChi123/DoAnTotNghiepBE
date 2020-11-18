package com.mta.shop.controllers.message;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class ProductAdminPagingRequest {
    private int pageSize;
    private int pageNumber;
    private String codeProduct;
    private String nameProduct;
    private List<Integer> loaiSanPham;
    private List<Integer> thuongHieu;
    private Float priceLower;
    private Float priceUpper;
}
