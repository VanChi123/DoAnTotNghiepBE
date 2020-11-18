package com.mta.shop.controllers.message;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class LoginRequest {
    private String userName;
    private String password;
}
