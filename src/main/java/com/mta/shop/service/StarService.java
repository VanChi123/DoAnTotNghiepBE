package com.mta.shop.service;

import com.mta.shop.entities.LoaiSanPham;
import com.mta.shop.entities.Star;
import com.mta.shop.repository.LoaiSanPhamRepository;
import com.mta.shop.repository.StarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StarService {
    @Autowired
    private StarRepository starRepository;

    public List<Star> getAll(){
        return starRepository.findAll();
    }

    public Optional<Star> findById(Integer id){
        return starRepository.findById(id);
    }

    public Star addNew(Star star){
        return starRepository.save(star);
    }

    public void delete(Integer id){
        Optional<Star> star = starRepository.findById(id);

        star.ifPresent(star1 -> starRepository.delete(star1));
    }

}
