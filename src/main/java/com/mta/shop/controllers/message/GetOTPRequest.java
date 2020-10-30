package com.mta.shop.controllers.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetOTPRequest {
    private String username;
    private String email;
}
