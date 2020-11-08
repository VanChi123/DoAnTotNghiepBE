package com.mta.shop.controllers;

import com.mta.shop.controllers.message.AppResponse;
import com.mta.shop.controllers.message.AppResponseFailure;
import com.mta.shop.controllers.message.AppResponseSuccess;
import com.mta.shop.controllers.message.ProductPaging;
import com.mta.shop.entities.LoaiSanPham;
import com.mta.shop.entities.SanPhamEntity;
import com.mta.shop.repository.SanPhamRepositoryCustomImp;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final SanPhamRepositoryCustomImp sanPhamRepositoryCustomImp;
    @GetMapping(value = "/get-all")
    public List<SanPhamEntity> getProductAll() {
        return sanPhamRepositoryCustomImp.findAllLoaiSanPham();
    }

    @GetMapping(value = "/get-one")
    public SanPhamEntity getProductOne() {
        return sanPhamRepositoryCustomImp.findProductByMaSanPham("SP01");
    }

    @GetMapping(value = "/get-one-cat")
    public LoaiSanPham getProductOneCat() {
        return sanPhamRepositoryCustomImp.findProductByMaSanPham("SP01").getLoaiSanPham();
    }

    @PostMapping(value = "/")
    public AppResponse getProductPaging(@RequestBody ProductPaging productPaging) {
        System.out.println("nhận body: " + productPaging.toString());
        AppResponse appResponse;
        Page<SanPhamEntity> list = sanPhamRepositoryCustomImp.findProductsPaging(productPaging.getPageNumber(), productPaging.getPageSize());

        if (null != list){
            appResponse = new AppResponseSuccess();
            appResponse.setData(list);
        }else {
            appResponse = new AppResponseFailure();
            appResponse.setData(null);
        }

        return appResponse;
    }

    @PostMapping(value = "/pro")
    public AppResponse getProductPaging1(@RequestBody ProductPaging productPaging) {
        System.out.println("nhận body: " + productPaging);
        AppResponse appResponse;
        Page<SanPhamEntity> list = sanPhamRepositoryCustomImp.findProductsPaging(productPaging.getPageNumber(), productPaging.getPageSize(), productPaging.getNameProduct());

        if (null != list){
            appResponse = new AppResponseSuccess();
            appResponse.setData(list);
        }else {
            appResponse = new AppResponseFailure();
            appResponse.setData(null);
        }

        return appResponse;
    }

    @GetMapping(value = "/view/{idSanPham}")
    public AppResponse getAProduct(@PathVariable("idSanPham") String maSanPham) {
        System.out.println("nhận body: " + maSanPham);
        AppResponse appResponse;

        SanPhamEntity sanPhamEntity = sanPhamRepositoryCustomImp.findProductByMaSanPham(maSanPham);
        if (null != sanPhamEntity){
            appResponse = new AppResponseSuccess();
            appResponse.setData(sanPhamEntity);
        }else {
            appResponse = new AppResponseFailure();
            appResponse.setData(null);
        }

        return appResponse;
    }
}
