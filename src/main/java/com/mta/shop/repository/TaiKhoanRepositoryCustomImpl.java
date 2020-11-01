package com.mta.shop.repository;

import com.mta.shop.entities.KhachHangEntity;
import com.mta.shop.entities.TaiKhoanEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

//@Service
@Repository
public class TaiKhoanRepositoryCustomImpl implements TaiKhoanRepositoryCustom {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Transactional
    public TaiKhoanEntity addCustomer(TaiKhoanEntity taiKhoanEntity){
        System.out.println("đii vào 1");
        TaiKhoanEntity entity = taiKhoanRepository.save(taiKhoanEntity);
        if (null != entity){
            KhachHangEntity khachHangEntity = new KhachHangEntity();
            khachHangEntity.setMaKhachHang("KH" + entity.getId());
            khachHangEntity.setIdTaiKhoan(entity.getId());

            khachHangRepository.save(khachHangEntity);
        }
        return entity;
    }

    @Transactional
    public TaiKhoanEntity addEmployee(TaiKhoanEntity taiKhoanEntity){
        System.out.println("đii vào 2");
        TaiKhoanEntity entity = taiKhoanRepository.save(taiKhoanEntity);
        if (null != entity){
            KhachHangEntity khachHangEntity = new KhachHangEntity();
            khachHangEntity.setMaKhachHang("KH" + entity.getId());
            khachHangEntity.setIdTaiKhoan(entity.getId());

            khachHangEntity = khachHangRepository.save(khachHangEntity);
        }
        return entity;
    }
}
