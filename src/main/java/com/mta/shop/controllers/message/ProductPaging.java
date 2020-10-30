package com.mta.shop.controllers.message;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
@Data
public class ProductPaging {
    private int pageSize;
    private int pageNumber;
    private String nameProduct;
}
