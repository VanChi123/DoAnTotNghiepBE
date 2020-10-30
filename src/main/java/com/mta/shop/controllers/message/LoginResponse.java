package com.mta.shop.controllers.message;

import com.mta.shop.entities.TaiKhoanEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
     private TaiKhoanEntity taiKhoanEntity;
}
