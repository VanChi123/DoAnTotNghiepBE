package com.mta.shop.service;

import com.mta.shop.controllers.message.ProductAdminPagingRequest;
import com.mta.shop.controllers.message.product.ProductAdminAddRequest;
import com.mta.shop.entities.LoaiSanPham;
import com.mta.shop.entities.SanPhamEntity;
import com.mta.shop.entities.ThuongHieuEntity;
import com.mta.shop.repository.SanPhamRepository;
import com.mta.shop.service.mapper.SanPhamDTO;
import com.mta.shop.service.utils.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class SanPhamService {
    @Autowired
    private SanPhamRepository sanPhamRepository;

    @Autowired
    private FileService fileService;

    @Autowired
    private ThuongHieuService thuongHieuService;

    @Autowired
    private LoaiSanPhamService loaiSanPhamService;

    public Page<SanPhamEntity> searchAdminPaging(ProductAdminPagingRequest request) {
        List<Integer> loaiSanPhamList = new ArrayList<>();
        List<Integer> thuongHieuList;

        if (null == request.getLoaiSanPham() || request.getLoaiSanPham().size() < 1) {
            loaiSanPhamList.addAll(Arrays.asList( 1, 2, 3));
        } else {
            loaiSanPhamList = request.getLoaiSanPham();
        }

        if (null == request.getThuongHieu() || request.getThuongHieu().size() < 1) {
            thuongHieuList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 9));
        } else {
            thuongHieuList = request.getThuongHieu();
        }

        return sanPhamRepository.searchAdminPaging(PageRequest.of(request.getPageNumber(), request.getPageSize()),
                request.getCodeProduct(),
                request.getNameProduct(),
                loaiSanPhamList,
                thuongHieuList,
                request.getPriceLower(),
                request.getPriceUpper()
        );
    }

    @Transactional
    public SanPhamEntity addProductAdmin(ProductAdminAddRequest request) throws IOException {
        SanPhamEntity sanPhamEntity = request.getSanPhamEntity();

        // nếu mã sản phẩm đã tồn tại thì trả về null để báo lỗi
        Optional<SanPhamEntity> sanPhamEntityOptional = sanPhamRepository.findByMaSanPham(sanPhamEntity.getMaSanPham());
        if (sanPhamEntityOptional.isPresent()) {
            return null;
        }

        // Save url to database
        String filePath = fileService.saveFile(request.getImgBase64(), request.getFileName(), request.getFileTail());
        if (null != filePath) {
            sanPhamEntity.setImg(filePath);
        }

        Integer idThuongHieu = sanPhamEntity.getThuongHieuEntity().getId();
        ThuongHieuEntity thuongHieuEntity = thuongHieuService.getThuongHieuById(idThuongHieu).get();
        System.out.println("th" + thuongHieuEntity);

        Integer idLoaiSanPham = sanPhamEntity.getLoaiSanPham().getId();
        LoaiSanPham loaiSanPham = loaiSanPhamService.findById(idThuongHieu).get();
        System.out.println("th" + loaiSanPham);


        sanPhamEntity.setThuongHieuEntity(thuongHieuEntity);
        sanPhamEntity.setLoaiSanPham(loaiSanPham);

        return sanPhamRepository.save(sanPhamEntity);
    }

    @Transactional
    public SanPhamEntity updateProductAdmin(ProductAdminAddRequest request) throws IOException {
        SanPhamEntity sanPhamEntityRequest = request.getSanPhamEntity();

        // nếu id phẩm không tồn tại thì trả về null để báo lỗi
        Optional<SanPhamEntity> sanPhamEntityOptional = sanPhamRepository.findById(sanPhamEntityRequest.getId());
        if (sanPhamEntityOptional.isEmpty()) {
            return null;
        }

        SanPhamEntity sanPhamEntity = sanPhamEntityOptional.get();

        // kiểm tra nếu đường dẫn gửi lên và đường dẫn trong db giống nhau thì ko cập nhật ảnh
        if (sanPhamEntity.getImg().equals(sanPhamEntityRequest.getImg())) {

        } else {
            // Save url to database
            String filePath = fileService.saveFile(request.getImgBase64(), request.getFileName(), request.getFileTail());
            if (null != filePath) {
                sanPhamEntity.setImg(filePath);
            }
        }

        // cập nhật thương hiệu và loại sản phẩm
        Integer idThuongHieu = sanPhamEntityRequest.getThuongHieuEntity().getId();
//        ThuongHieuEntity thuongHieuEntity = thuongHieuService.getThuongHieuById(idThuongHieu).get();
//        System.out.println("th" + thuongHieuEntity);

        Integer idLoaiSanPham = sanPhamEntityRequest.getLoaiSanPham().getId();
//        LoaiSanPham loaiSanPham = loaiSanPhamService.findById(idLoaiSanPham).get();
//        System.out.println("th" + loaiSanPham);

        sanPhamEntity.setMaSanPham(sanPhamEntityRequest.getMaSanPham());
        sanPhamEntity.setTenSanPham(sanPhamEntityRequest.getTenSanPham());
        sanPhamEntity.setGia(sanPhamEntityRequest.getGia());
        sanPhamEntity.setDoiTuongSuDung(sanPhamEntityRequest.getDoiTuongSuDung());
        sanPhamEntity.setKichThuocBeMat(sanPhamEntityRequest.getKichThuocBeMat());
        sanPhamEntity.setChatLieuMatKinh(sanPhamEntityRequest.getChatLieuMatKinh());
        sanPhamEntity.setChatLieuDay(sanPhamEntityRequest.getChatLieuDay());
        sanPhamEntity.setDoDay(sanPhamEntityRequest.getDoDay());
        sanPhamEntity.setDoDai(sanPhamEntityRequest.getDoDai());
        sanPhamEntity.setKieuKhoa(sanPhamEntityRequest.getKieuKhoa());
        sanPhamEntity.setDoRongCuaDay(sanPhamEntityRequest.getDoRongCuaDay());

        sanPhamEntity.setChatLieuVoMay(sanPhamEntityRequest.getChatLieuVoMay());
        sanPhamEntity.setMay(sanPhamEntityRequest.getMay());
        sanPhamEntity.setKhaNangChiuNuoc(sanPhamEntityRequest.getKhaNangChiuNuoc());
        sanPhamEntity.setGiamGia(sanPhamEntityRequest.getGiamGia());
        sanPhamEntity.setImg(sanPhamEntityRequest.getImg());

        sanPhamEntity.setLoaiSanPham(loaiSanPhamService.findById(idLoaiSanPham).isEmpty() ? null : loaiSanPhamService.findById(idLoaiSanPham).get());
        sanPhamEntity.setThuongHieuEntity(thuongHieuService.getThuongHieuById(idLoaiSanPham).isEmpty() ? null : thuongHieuService.getThuongHieuById(idLoaiSanPham).get());
        sanPhamEntity.setNgayCapNhap(new java.sql.Date(System.currentTimeMillis()));

        return sanPhamRepository.save(sanPhamEntity);
    }

    public SanPhamDTO getAProduct(Integer idSanPham) throws IOException {
        Optional<SanPhamEntity> sanPhamEntity = sanPhamRepository.findById(idSanPham);

        if (sanPhamEntity.isEmpty()) {
            return null;
        }

        SanPhamEntity sanPhamEntity1 = sanPhamEntity.get();

        return new SanPhamDTO(sanPhamEntity1, getImgBase64(sanPhamEntity1.getImg()), "");
    }

    public Boolean deleteAProduct(Integer idSanPham) throws IOException {
        Optional<SanPhamEntity> sanPhamEntity = sanPhamRepository.findById(idSanPham);

        if (sanPhamEntity.isEmpty()) {
            return null;
        }

        SanPhamEntity sanPhamEntity1 = sanPhamEntity.get();

        sanPhamRepository.delete(sanPhamEntity1);

        if (sanPhamRepository.findById(idSanPham).isEmpty())
            return true;
        return false;
    }

    public String getImgBase64(String path) throws IOException {
        return fileService.getFile(path);
    }

}
