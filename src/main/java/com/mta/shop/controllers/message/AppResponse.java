package com.mta.shop.controllers.message;

import lombok.Data;

@Data
public abstract class AppResponse {
    private Boolean success;
    private Object data;
}

