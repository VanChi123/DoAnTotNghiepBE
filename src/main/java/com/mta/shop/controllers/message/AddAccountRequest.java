package com.mta.shop.controllers.message;

import lombok.Data;

@Data
public class AddAccountRequest {
    private String typeAccount;
    private String userName;
    private String password;
    private String email;
}
