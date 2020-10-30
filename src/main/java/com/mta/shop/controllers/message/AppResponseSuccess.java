package com.mta.shop.controllers.message;

import com.mta.shop.constant.AppConstant;

public class AppResponseSuccess extends AppResponse {
    public AppResponseSuccess(){
        this.setSuccess(AppConstant.RESULT_SUCCESS);
    }
}
