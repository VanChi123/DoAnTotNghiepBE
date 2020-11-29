package com.mta.shop.service;

import com.mta.shop.entities.GioHang;
import com.mta.shop.entities.ThuongHieuEntity;
import com.mta.shop.repository.BinhLuanRepository;
import com.mta.shop.repository.GioHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class GioHangService {
    @Autowired
    private GioHangRepository gioHangRepository;

    public Page<GioHang> getAll(PageRequest pageRequest){
        return gioHangRepository.findAll(pageRequest);
    }

    public GioHang add(GioHang gioHang){
        return gioHangRepository.save(gioHang);
    }

    public Optional<GioHang> getGioHangById(Integer id){
        return gioHangRepository.findById(id);
    }

    public void delete(Integer id){
        Optional<GioHang> gioHang = gioHangRepository.findById(id);
        gioHangRepository.delete(gioHang.get());
    }
}
