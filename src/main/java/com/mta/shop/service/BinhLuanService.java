package com.mta.shop.service;

import com.mta.shop.entities.BinhLuan;
import com.mta.shop.repository.BinhLuanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;

@Service
public class BinhLuanService {
    @Autowired
    private BinhLuanRepository binhLuanRepository;
//
//    @Transactional
//    public Boolean addBinhLuan(BinhLuan binhLuan){
//        BinhLuan binhLuanResult = binhLuanRepository.save(binhLuan);
//        if (null != binhLuanResult){
//            return true;
//        }else
//            return false;
//    }

    @Transactional
    public void addBinhLuan(Integer idTaiKhoan, Integer idSanPham, Instant ngayGio, String noiDung,
                                String tenKhachHang, String soDienThoai){
        binhLuanRepository.addBinhLuan(idTaiKhoan, idSanPham, ngayGio, noiDung, tenKhachHang, soDienThoai);
    }
}
