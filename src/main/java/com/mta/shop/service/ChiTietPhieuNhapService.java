package com.mta.shop.service;

import com.mta.shop.entities.ChiTietPhieuNhap;
import com.mta.shop.entities.ChiTietPhieuNhapPK;
import com.mta.shop.repository.ChiTietPhieuNhapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChiTietPhieuNhapService {
    @Autowired
    private ChiTietPhieuNhapRepository chiTietPhieuNhapRepository;

    public Page<ChiTietPhieuNhap> getAllPaging(int pageNumber){
        return  chiTietPhieuNhapRepository.findAll(PageRequest.of(pageNumber, 10));
    }

    public Optional<ChiTietPhieuNhap> findOne(ChiTietPhieuNhapPK id){
        return chiTietPhieuNhapRepository.findById(id);
    }

    public void deleteById(ChiTietPhieuNhapPK id){
        chiTietPhieuNhapRepository.deleteById(id);
    }

    public ChiTietPhieuNhap saveOne(ChiTietPhieuNhap chiTietPhieuNhap){
        return chiTietPhieuNhapRepository.save(chiTietPhieuNhap);
    }
}
