package com.mta.shop.service;

import com.mta.shop.entities.LoaiSanPham;
import com.mta.shop.repository.LoaiSanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoaiSanPhamService {
    @Autowired
    private LoaiSanPhamRepository loaiSanPhamRepository;

    public List<LoaiSanPham> getAll(){
        return loaiSanPhamRepository.findAll();
    }

    public Optional<LoaiSanPham> findById(Integer id){
        return loaiSanPhamRepository.findById(id);
    }

    public LoaiSanPham addNew(LoaiSanPham loaiSanPham){
        return loaiSanPhamRepository.save(loaiSanPham);
    }

    public void delete(Integer id){
        Optional<LoaiSanPham> loaiSanPham = loaiSanPhamRepository.findById(id);

        loaiSanPham.ifPresent(sanPham -> loaiSanPhamRepository.delete(sanPham));
    }

}
