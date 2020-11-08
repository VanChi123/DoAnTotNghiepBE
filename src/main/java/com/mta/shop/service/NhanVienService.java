package com.mta.shop.service;

import com.mta.shop.entities.NhanVienEntity;
import com.mta.shop.entities.ThuongHieuEntity;
import com.mta.shop.repository.NhanVienRepository;
import com.mta.shop.repository.ThuongHieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    public Optional<NhanVienEntity> findOne(Integer id){
        return nhanVienRepository.findById(id);
    }

    public Optional<NhanVienEntity> findOneByIdTaiKhoan(Integer id){
        return nhanVienRepository.findByIdTaiKhoan(id);
    }

    public void deleteById(Integer id){
        nhanVienRepository.deleteById(id);
    }

    public NhanVienEntity saveOne(NhanVienEntity nhanVienEntity){
        return nhanVienRepository.save(nhanVienEntity);
    }
}
