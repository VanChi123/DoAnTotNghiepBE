package com.mta.shop.controllers.message;

import lombok.Data;

@Data
public class UpdatePassword {
    private String userName;
    private String newPassword;
}
