package com.mta.shop.repository;

import com.mta.shop.entities.KhachHangEntity;
import com.mta.shop.entities.TaiKhoanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class KhachHangRepositoryCustomImpl implements KhachHangRepositoryCustom {

    @Autowired
    private TaiKhoanService taiKhoanService;

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public KhachHangEntity getKhachHang(String tenDangNhap) {
        Optional<TaiKhoanEntity> taiKhoanEntity = taiKhoanService.findByTenDangNhap(tenDangNhap);

        if (!taiKhoanEntity.isPresent()){
            return  null;
        }
        KhachHangEntity khachHangEntity = khachHangRepository.findByIdTaiKhoan(taiKhoanEntity.get().getId());
        return khachHangEntity;
    }
}
