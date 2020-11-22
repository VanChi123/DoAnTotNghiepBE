package com.mta.shop.service;

import com.mta.shop.entities.HoaDon;
import com.mta.shop.repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class HoaDonService {

    @Autowired
    private HoaDonRepository hoaDonRepository;

   public Optional<HoaDon> findById(Integer id){
       return hoaDonRepository.findById(id);
   }

    public List<HoaDon> getAll(){
        return hoaDonRepository.findAll();
    }

   @Transactional
   public HoaDon save(HoaDon hoaDon){
       return hoaDonRepository.save(hoaDon);
   }

}
