package com.mta.shop.controllers.message;

import com.mta.shop.constant.AppConstant;

public class AppResponseFailure extends AppResponse {
    public AppResponseFailure(){
        this.setSuccess(AppConstant.RESULT_ERROR);
    }
}