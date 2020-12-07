package com.mta.shop.service;

import com.mta.shop.entities.ThuongHieuEntity;
import com.mta.shop.repository.ThuongHieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ThuongHieuService {
    @Autowired
    private ThuongHieuRepository thuongHieuRepository;

    public List<ThuongHieuEntity> getAll(){
        return thuongHieuRepository.findAll();
    }

    public List<Integer> getAllId(){
        return thuongHieuRepository.getAllId();
    }

    public ThuongHieuEntity addThuongHieu(ThuongHieuEntity thuongHieuEntity){
        return thuongHieuRepository.save(thuongHieuEntity);
    }

    public Optional<ThuongHieuEntity> getThuongHieuById(Integer id){
        return thuongHieuRepository.findById(id);
    }

    public void deleteModel(Integer id){
         Optional<ThuongHieuEntity> thuongHieuEntity = thuongHieuRepository.findById(id);
        thuongHieuRepository.delete(thuongHieuEntity.get());
    }
}
