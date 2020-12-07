package com.mta.shop.service;

import com.mta.shop.entities.NhanVienEntity;
import com.mta.shop.repository.NhanVienRepository;
import com.mta.shop.service.mapper.NhanVienDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;

    public List<NhanVienDTO> getAllDTO() {
        return nhanVienRepository.findAll().stream().map(e -> new NhanVienDTO(e)).collect(Collectors.toList());
    }

    public Page<NhanVienEntity> getAllPaging(int pageNumber){
        return  nhanVienRepository.findAll(PageRequest.of(pageNumber, 10));
    }

    public Optional<NhanVienEntity> findOne(Integer id){
        return nhanVienRepository.findById(id);
    }

    public NhanVienEntity findOneByIdTaiKhoan(Integer id){
        return nhanVienRepository.findByIdTaiKhoan(id);
    }

    public void deleteById(Integer id){
        nhanVienRepository.deleteById(id);
    }

    public NhanVienEntity saveOne(NhanVienEntity nhanVienEntity){
        return nhanVienRepository.save(nhanVienEntity);
    }
}
