package com.mta.shop.service;

import com.mta.shop.controllers.message.UpdateInformationCustomerRequest;
import com.mta.shop.entities.KhachHangEntity;
import com.mta.shop.repository.KhachHangRepository;
import com.mta.shop.repository.KhachHangRepositoryCustom;
import com.mta.shop.service.utils.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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

//KhachHangEntity khachHangEntity = khachHangRepository.findByIdTaiKhoan(request.getIdTaiKhoan());
//
//        khachHangEntity.setMaKhachHang(request.getMaKhachHang());
//        khachHangEntity.setDiaChi(request.getDiaChi());
//        khachHangEntity.setGioiTinh(request.getGioiTinh());
////        khachHangEntity.setNgaySinh(request.getNgaySinh());
//        khachHangEntity.setNgaySinh(new java.sql.Date(request.getNgaySinh().getTime()));
//        //khachHangEntity.setNgaySinh(new java.sql.Timestamp(request.getNgaySinh().getTime()));
//        khachHangEntity.setTenKhachHang(request.getTenKhachHang());
//
//        // kiểm tra ảnh mới và cũ có khác nhau ko , nếu khác nhau thì xóa ảnh cũ
//        if (!theSamePath){
//            System.out.println("không cùng path rồi, xóa file cũ");
//            System.out.println("path: " +request.getFilePathOld());
//            fileService.deleteFileIfExist(request.getFilePathOld());
//        }
//        khachHangEntity.setImg(request.getImg());
//        khachHangEntity.setSoDienThoai(request.getSoDienThoai());

  //      return khachHangRepository.save(khachHangEntity);
        return  null;
    }

    public String getImgBase64(String path) throws IOException {
        return fileService.getFile(path);
    }

    public KhachHangEntity saveOne(KhachHangEntity khachHangEntity){
        return khachHangRepository.save(khachHangEntity);
    }

//    public KhachHangEntity findByIdTaiKhoan(Integer id){
//        return khachHangRepository.findByIdTaiKhoan(id);
//    }

    public KhachHangEntity getKhachHangByUserName(String tenDangNhap){
        return khachHangRepositoryCustom.getKhachHang(tenDangNhap);
    }

    // lấy tất cả khách hàng
    public List<KhachHangEntity> getAll(){
        return khachHangRepository.findAll();
    }

    // lấy tất cả khách hàng phân trang
    public Page<KhachHangEntity> getAllPaging(PageRequest pageRequest){
        return khachHangRepository.findAll(pageRequest);
    }

    // lấy theo id
    public Optional<KhachHangEntity> getById(Integer id){
        return khachHangRepository.findById(id);
    }

    // thêm mới + cập nhật
    public KhachHangEntity add(KhachHangEntity khachHangEntity){
        return khachHangRepository.save(khachHangEntity);
    }

    // xóa
    public void delete(KhachHangEntity khachHangEntity){
        khachHangRepository.delete(khachHangEntity);
    }
}
