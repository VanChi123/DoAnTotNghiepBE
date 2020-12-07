package com.mta.shop.service;

import com.mta.shop.entities.PhieuNhap;
import com.mta.shop.repository.PhieuNhapRepository;
import com.mta.shop.service.mapper.PhieuNhapDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PhieuNhapService {
    @Autowired
    private PhieuNhapRepository phieuNhapRepository;

    public List<PhieuNhapDTO> getAllDTO() {
        return phieuNhapRepository.findAll().stream().map(e -> new PhieuNhapDTO(e)).collect(Collectors.toList());
    }

    public Page<PhieuNhap> getAllPaging(int pageNumber){
        return  phieuNhapRepository.findAll(PageRequest.of(pageNumber, 10));
    }

    public Optional<PhieuNhap> findOne(Integer id){
        return phieuNhapRepository.findById(id);
    }

    public void deleteById(Integer id){
        phieuNhapRepository.deleteById(id);
    }

    public PhieuNhap saveOne(PhieuNhap phieuNhap){
        return phieuNhapRepository.save(phieuNhap);
    }
}
