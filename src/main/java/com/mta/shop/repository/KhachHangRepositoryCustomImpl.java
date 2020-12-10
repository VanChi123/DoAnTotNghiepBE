package com.mta.shop.repository;

import com.mta.shop.entities.KhachHangEntity;
import com.mta.shop.entities.TaiKhoanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class KhachHangRepositoryCustomImpl implements KhachHangRepositoryCustom {

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public KhachHangEntity getKhachHang(String tenDangNhap) {
        Optional<TaiKhoanEntity> taiKhoanEntity = taiKhoanRepository.findByTenDangNhap(tenDangNhap);

        if (taiKhoanEntity.isEmpty()){ // !ispresent = isempty
            return  null;
        }
        return khachHangRepository.findByIdTaiKhoan(taiKhoanEntity.get().getId());
    }
}
