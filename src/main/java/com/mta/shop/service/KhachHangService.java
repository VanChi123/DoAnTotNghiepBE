package com.mta.shop.service;

import com.mta.shop.configure.Constant;
import com.mta.shop.controllers.message.UpdateInformationCustomerRequest;
import com.mta.shop.entities.KhachHangEntity;
import com.mta.shop.entities.NhanVienEntity;
import com.mta.shop.repository.KhachHangRepository;
import com.mta.shop.repository.KhachHangRepositoryCustom;
import com.mta.shop.service.utils.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

@Service
public class KhachHangService {
    @Autowired
    private FileService fileService;

    @Autowired
    private KhachHangRepository khachHangRepository;

    @Autowired
    KhachHangRepositoryCustom khachHangRepositoryCustom;

    public KhachHangEntity updateCustomer(UpdateInformationCustomerRequest request) throws IOException {
        // file upleen có trùng với file gốc ?
        boolean theSamePath = false;

        // Save url to database
        String filePath = fileService.saveFile(request.getImgBase64(), request.getImg(), request.getFileTail());
        if (null != filePath){
            request.setImg(filePath);
        }

        if (request.getFilePathOld().replaceAll(" ", "").equals(filePath)){
            theSamePath = true;
        }

         KhachHangEntity khachHangEntity = khachHangRepository.findByIdTaiKhoan(request.getIdTaiKhoan());

        khachHangEntity.setMaKhachHang(request.getMaKhachHang());
        khachHangEntity.setDiaChi(request.getDiaChi());
        khachHangEntity.setGioiTinh(request.getGioiTinh());
//        khachHangEntity.setNgaySinh(request.getNgaySinh());
        khachHangEntity.setNgaySinh(new java.sql.Date(request.getNgaySinh().getTime()));
        //khachHangEntity.setNgaySinh(new java.sql.Timestamp(request.getNgaySinh().getTime()));
        khachHangEntity.setTenKhachHang(request.getTenKhachHang());

        // kiểm tra ảnh mới và cũ có khác nhau ko , nếu khác nhau thì xóa ảnh cũ
        if (!theSamePath){
            System.out.println("không cùng path rồi, xóa file cũ");
            System.out.println("path: " +request.getFilePathOld());
            fileService.deleteFileIfExist(request.getFilePathOld());
        }
        khachHangEntity.setImg(request.getImg());
        khachHangEntity.setSoDienThoai(request.getSoDienThoai());

        return khachHangRepository.save(khachHangEntity);
    }

    public String getImgBase64(String path) throws IOException {
        return fileService.getFile(path);
    }

    public KhachHangEntity saveOne(KhachHangEntity khachHangEntity){
        return khachHangRepository.save(khachHangEntity);
    }

    public KhachHangEntity findByIdTaiKhoan(Integer id){
        return khachHangRepository.findByIdTaiKhoan(id);
    }

    public KhachHangEntity getKhachHangByUserName(String tenDangNhap){
        return khachHangRepositoryCustom.getKhachHang(tenDangNhap);
    }



}
