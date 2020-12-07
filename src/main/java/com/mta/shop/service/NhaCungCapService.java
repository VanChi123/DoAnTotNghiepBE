package com.mta.shop.service;

import com.mta.shop.entities.NhaCungCap;
import com.mta.shop.repository.NhaCungCapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhaCungCapService {
    @Autowired
    private NhaCungCapRepository nhaCungCapRepository;

    public List<NhaCungCap> getAll(){
        return  nhaCungCapRepository.findAll();
    }

    public Page<NhaCungCap> getAllPaging(int pageNumber){
        return  nhaCungCapRepository.findAll(PageRequest.of(pageNumber, 10));
    }

    public Optional<NhaCungCap> findOne(Integer id){
        return nhaCungCapRepository.findById(id);
    }

    public void deleteById(Integer id){
        nhaCungCapRepository.deleteById(id);
    }

    public NhaCungCap saveOne(NhaCungCap nhaCungCap){
        return nhaCungCapRepository.save(nhaCungCap);
    }
}
