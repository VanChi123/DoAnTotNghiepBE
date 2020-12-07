package com.mta.shop.service;

import com.mta.shop.entities.GiamGia;
import com.mta.shop.entities.NhaCungCap;
import com.mta.shop.repository.GiamGiaRepository;
import com.mta.shop.repository.NhaCungCapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GiamGiaService {
    @Autowired
    private GiamGiaRepository giamGiaRepository;

    public Page<GiamGia> getAllPaging(int pageNumber){
        return  giamGiaRepository.findAll(PageRequest.of(pageNumber, 10));
    }

    public Optional<GiamGia> findOne(Integer id){
        return giamGiaRepository.findById(id);
    }

    public void deleteById(Integer id){
        giamGiaRepository.deleteById(id);
    }

    public GiamGia saveOne(GiamGia giamGia){
        return giamGiaRepository.save(giamGia);
    }
}
