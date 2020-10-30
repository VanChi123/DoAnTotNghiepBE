package com.mta.shop.service;

import com.mta.shop.configure.Constant;
import com.mta.shop.controllers.message.UpdateInformationCustomerRequest;
import com.mta.shop.entities.KhachHangEntity;
import com.mta.shop.repository.KhachHangRepository;
import com.mta.shop.repository.KhachHangRepositoryCustom;
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
    private KhachHangRepository khachHangRepository;

    @Autowired
    KhachHangRepositoryCustom khachHangRepositoryCustom;

    public KhachHangEntity updateCustomer(UpdateInformationCustomerRequest request, boolean theSamePath) {
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
            deleteFileIfExist(request.getFilePathOld());
        }
        khachHangEntity.setImg(request.getImg());
        khachHangEntity.setSoDienThoai(request.getSoDienThoai());

        return khachHangRepository.save(khachHangEntity);
    }

    public String saveFile(String imgBase64, String fileName, String fileTail) throws IOException {
        makeDirectoryIfNotExist();

        Path filePath = Paths.get(Constant.IMAGES_DIR_DEFAULT,
                fileName.concat(".").concat(fileTail));
// nếu tên file trùng thì tự động nó sẽ thay thế nên ko phải gọi hàm xóa
//        deleteFileIfExist(filePath.toString());

        System.out.println("bưats đầu vào hàm saveFile");
        System.out.println("fie path: " + filePath);
        System.out.println("fie path: " + fileName);
        System.out.println("fie path: " + fileTail);
        //System.out.println("fie path: "+ imgBase64);
        try {
//            byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
//            FileUtils.writeByteArrayToFile(new File(outputFileName), decodedBytes);


            //byte[] decodedBytes = Base64.getDecoder().decode(imgBase64);
            byte[] decodedBytes = Base64.getMimeDecoder().decode(imgBase64);
            FileUtils.writeByteArrayToFile(new File(filePath.toString()), decodedBytes);

            System.out.println("file path:tositring:  " + filePath.toString());
            return filePath.toString();
        } catch (IOException e) {
//            LOGGER.info("Can not save img {}", filePath.toString());
            throw e;
        }
    }

    public String getFile(String filePath) throws IOException {
        try {
            File file = new File(filePath.replaceAll(" ", ""));
            //String imgBase64 = "";
//            if (file.canRead()) {

            byte[] fileContent = FileUtils.readFileToByteArray(new File(filePath));
            String imgBase64 = Base64.getEncoder().encodeToString(fileContent);
//
//            }

            return imgBase64;
        } catch (IOException e) {
            throw e;
        }
    }

    private void makeDirectoryIfNotExist() {
        File directory = new File(Constant.IMAGES_DIR_DEFAULT);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    private void deleteFileIfExist(String pathFile) {
        File file = new File(pathFile);

        if (null != file) {
            file.delete();
        }

        System.out.println("pass delete file if trùng");
    }

}
