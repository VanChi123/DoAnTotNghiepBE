package com.mta.shop.controllers.message.taikhoan;

import com.mta.shop.entities.TaiKhoanEntity;
import lombok.Data;

import java.util.List;

@Data
public class AddAccountManyRoleRequest {
    private Integer id; // dùng cho update
    private TaiKhoanEntity newTaiKhoanEntity;
    private List<Integer> idRoles;
}
