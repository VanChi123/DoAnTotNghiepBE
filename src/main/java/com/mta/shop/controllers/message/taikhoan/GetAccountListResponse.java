package com.mta.shop.controllers.message.taikhoan;

import com.mta.shop.entities.TaiKhoanEntity;
import lombok.Data;
import org.springframework.data.domain.Page;

@Data
public class GetAccountListResponse {
    private Page<TaiKhoanEntity> accounts;
}
