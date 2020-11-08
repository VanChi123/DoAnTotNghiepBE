package com.mta.shop.service;

import com.mta.shop.entities.SanPhamEntity;
import com.mta.shop.repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamService {
    @Autowired
    private SanPhamRepository sanPhamRepository;

    public List<SanPhamEntity> getAllSanPham(){
        return sanPhamRepository.findAll();
    }
}
