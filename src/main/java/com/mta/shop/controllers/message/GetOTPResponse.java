package com.mta.shop.controllers.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetOTPResponse {
    private boolean success;
    private String key;
}
