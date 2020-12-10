package com.mta.shop.service;

import com.mta.shop.entities.HoaDon;
import com.mta.shop.repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    public Page<HoaDon> getAllPaging(int pageNumber){
        return  hoaDonRepository.findAll(PageRequest.of(pageNumber, 10));
    }

    public Optional<HoaDon> findOne(Integer id){
        return hoaDonRepository.findById(id);
    }

    public void deleteById(Integer id){
        hoaDonRepository.deleteById(id);
    }

    public HoaDon saveOne(HoaDon hoaDon){
        return hoaDonRepository.save(hoaDon);
    }

}
