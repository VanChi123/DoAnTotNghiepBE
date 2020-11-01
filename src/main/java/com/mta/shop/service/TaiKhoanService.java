package com.mta.shop.service;

import com.mta.shop.controllers.message.UpdatePassword;
import com.mta.shop.entities.TaiKhoanEntity;
import com.mta.shop.repository.TaiKhoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaiKhoanService {

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    public TaiKhoanEntity updatePassword(UpdatePassword request){
        TaiKhoanEntity taiKhoanEntityUpdate = null;
        Optional<TaiKhoanEntity> taiKhoanEntity = taiKhoanRepository.findByTenDangNhap(request.getUserName());

        if (taiKhoanEntity.isPresent()){
            taiKhoanEntityUpdate = taiKhoanEntity.get();
            taiKhoanEntityUpdate.setMatKhau(request.getNewPassword());

            taiKhoanEntityUpdate = taiKhoanRepository.save(taiKhoanEntityUpdate);
        }

        return  taiKhoanEntityUpdate;
    }
}
