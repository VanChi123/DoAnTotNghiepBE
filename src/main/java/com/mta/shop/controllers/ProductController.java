package com.mta.shop.controllers;

import com.mta.shop.controllers.message.AppResponse;
import com.mta.shop.controllers.message.AppResponseFailure;
import com.mta.shop.controllers.message.AppResponseSuccess;
import com.mta.shop.controllers.message.ProductAdminPagingRequest;
import com.mta.shop.controllers.message.product.ProductAdminAddRequest;
import com.mta.shop.entities.KhachHangEntity;
import com.mta.shop.entities.SanPhamEntity;
import com.mta.shop.service.SanPhamService;
import com.mta.shop.service.mapper.SanPhamDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final SanPhamService sanPhamService;

    // lấy tất cả
    @GetMapping(value = "/")
    public AppResponse getAllProduct(){
        AppResponse appResponse;

        List<SanPhamEntity> list = sanPhamService.getAll();

        appResponse = new AppResponseSuccess();
        appResponse.setData(list);
        return appResponse;
    }

//    @GetMapping(value = "/get-all")
//    public List<SanPhamEntity> getProductAll() {
//        return sanPhamRepositoryCustomImp.findAllLoaiSanPham();
//    }
//
//    @GetMapping(value = "/get-one")
//    public SanPhamEntity getProductOne() {
//        return sanPhamRepositoryCustomImp.findProductByMaSanPham("SP01");
//    }

//    @GetMapping(value = "/get-one-cat")
//    public LoaiSanPham getProductOneCat() {
//        return sanPhamRepositoryCustomImp.findProductByMaSanPham("SP01").getLoaiSanPham();
//    }

    // lấy tất cả sản phẩm: find all paging
    @PostMapping(value = "/")
    public AppResponse getProductPaging(@RequestBody ProductAdminPagingRequest productPaging) {
        System.out.println("nhận body: " + productPaging.toString());
        AppResponse appResponse;
        // Page<SanPhamEntity> list = sanPhamRepositoryCustomImp.findProductsPaging(productPaging.getPageNumber(), productPaging.getPageSize());
        Page<SanPhamDTO> list = sanPhamService.searchAdminPaging(productPaging).map(e -> {
            try {
                return new SanPhamDTO(e, sanPhamService.getImgBase64(e.getAnhDaiDien()), "");
            } catch (IOException ioException) {
                return null;  // ioException.printStackTrace();
            }
        });

        appResponse = new AppResponseSuccess();
        appResponse.setData(list);
        return appResponse;
    }

    // thêm mới sản phẩm cho admin
    @PostMapping(value = "/add")
    public AppResponse addProductAdmin(@RequestBody ProductAdminAddRequest request) throws IOException {
        System.out.println("nhận body: " + request.getSanPhamEntity().toString());
        AppResponse appResponse;
        SanPhamEntity sanPhamEntity = sanPhamService.addProductAdmin(request);

        if (null != sanPhamEntity){
            appResponse = new AppResponseSuccess();
            appResponse.setData(sanPhamEntity);
        }else {
            appResponse = new AppResponseFailure();
            appResponse.setData(null);
        }

        return appResponse;
    }

    // get 1 sản phẩm
    @GetMapping(value = "/get")
    public AppResponse getAProduct(@RequestParam Integer idSanPham) throws IOException {
        System.out.println("nhận body: " + idSanPham);
        AppResponse appResponse;
        SanPhamDTO sanPhamDTO = sanPhamService.getAProduct(idSanPham);

        if (null != sanPhamDTO){
            appResponse = new AppResponseSuccess();
            appResponse.setData(sanPhamDTO);
        }else {
            appResponse = new AppResponseFailure();
            appResponse.setData(null);
        }
        return appResponse;
    }


    // cập nhật sản phẩm cho admin
    @PostMapping(value = "/update")
    public AppResponse updateProductAdmin(@RequestBody ProductAdminAddRequest request) throws IOException {
        System.out.println("nhận body: " + request.getSanPhamEntity().toString());
        AppResponse appResponse;
        SanPhamEntity sanPhamEntity = sanPhamService.updateProductAdmin(request);

        if (null != sanPhamEntity){
            appResponse = new AppResponseSuccess();
            appResponse.setData(sanPhamEntity);
        }else {
            appResponse = new AppResponseFailure();
            appResponse.setData(null);
        }

        return appResponse;
    }

    // cập nhật sản phẩm cho admin
    @GetMapping(value = "/delete")
    public AppResponse deleteProductAdmin(@RequestParam Integer idSanPham) throws IOException {

        AppResponse appResponse;
        Boolean aBoolean  = sanPhamService.deleteAProduct(idSanPham);

        if (aBoolean){
            appResponse = new AppResponseSuccess();
        }else {
            appResponse = new AppResponseFailure();
        }

        return appResponse;
    }

    // tìm kiếm sản phâm theo tên
//    @PostMapping(value = "/pro")
//    public AppResponse getProductPaging1(@RequestBody ProductPaging productPaging) {
//        System.out.println("nhận body: " + productPaging);
//        AppResponse appResponse;
//        //Page<SanPhamEntity> list = sanPhamRepositoryCustomImp.findProductsPaging(productPaging.getPageNumber(), productPaging.getPageSize(), productPaging.getNameProduct());
//
//        if (null != list){
//            appResponse = new AppResponseSuccess();
//            appResponse.setData(list);
//        }else {
//            appResponse = new AppResponseFailure();
//            appResponse.setData(null);
//        }
//
//        return appResponse;
//    }

    // lấy thông tin 1 sản phẩm theo mã sản phẩm
//    @GetMapping(value = "/view/{idSanPham}")
//    public AppResponse getAProduct(@PathVariable("idSanPham") String maSanPham) {
//        System.out.println("nhận body: " + maSanPham);
//        AppResponse appResponse;
//
//        SanPhamEntity sanPhamEntity = sanPhamService.findProductByMaSanPham(maSanPham);
//        if (null != sanPhamEntity){
//            appResponse = new AppResponseSuccess();
//            appResponse.setData(sanPhamEntity);
//        }else {
//            appResponse = new AppResponseFailure();
//            appResponse.setData(null);
//        }
//
//        return appResponse;
//    }
}
