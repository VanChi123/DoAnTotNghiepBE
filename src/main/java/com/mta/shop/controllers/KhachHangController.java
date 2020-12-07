package com.mta.shop.controllers;

import com.mta.shop.controllers.message.*;
import com.mta.shop.controllers.message.khachhang.AddCustomerRequest;
import com.mta.shop.entities.KhachHangEntity;
import com.mta.shop.entities.QuyenSuDungEntity;
import com.mta.shop.entities.TaiKhoanEntity;
import com.mta.shop.service.KhachHangService;
import com.mta.shop.service.QuyenSuDungService;
import com.mta.shop.service.TaiKhoanService;
import com.mta.shop.service.mapper.KhachHangDTO;
import com.mta.shop.service.utils.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class KhachHangController {
    private final KhachHangService khachHangService;
    private final FileService fileService;
    private final TaiKhoanService taiKhoanService;
    private final QuyenSuDungService quyenSuDungService;

    // lấy tất cả
    @GetMapping(value = "/")
    public AppResponse getAllCustomer(){
        AppResponse appResponse;

        List<KhachHangEntity> list = khachHangService.getAll();

        appResponse = new AppResponseSuccess();
        appResponse.setData(list);
        return appResponse;
    }

    // lấy tất cả paging
    @GetMapping(value = "/getAll")
    public AppResponse getAllPaging(@RequestParam Integer pageNumber){
        AppResponse appResponse;

        Page<KhachHangEntity> list = khachHangService.getAllPaging(PageRequest.of(pageNumber, 10));

        appResponse = new AppResponseSuccess();
        appResponse.setData(list);
        return appResponse;
    }

    // thêm mới
    @PostMapping(value = "/add")
    @Transactional
    public AppResponse addCustomer(@RequestBody AddCustomerRequest request) throws IOException {
        AppResponse appResponse;

        // lấy khách hàng từ request, lưu ảnh vào để láy đường dẫn
        KhachHangEntity khachHangEntity = request.getKhachHangEntity();

        String path = "";
        if (null != khachHangEntity.getImg() && null != request.getImgBase64()){
            path = fileService.saveFileFullName(request.getImgBase64(), khachHangEntity.getImg());
        }

        // set các giá trì cho khach hàng để lưu
        khachHangEntity.setImg(path);

        Integer idTaiKhoan = khachHangEntity.getTaiKhoanEntity().getId();
        System.out.println("id" + idTaiKhoan);

        if (null != idTaiKhoan){
            Optional<TaiKhoanEntity> taiKhoanEntity = taiKhoanService.getById(idTaiKhoan);
            if (taiKhoanEntity.isPresent()){
                TaiKhoanEntity taiKhoanEntity1 = taiKhoanEntity.get();

                // cập nhật quyền là khách hàng cho tài khoản
                List<QuyenSuDungEntity> list = new ArrayList<>();
                list.add(quyenSuDungService.findById(2));
                taiKhoanEntity1.setQuyenSuDungEntities(list);

                taiKhoanEntity1 = taiKhoanService.updateAcc(taiKhoanEntity1);
                System.out.println("Tke"+ taiKhoanEntity1);

                // gán tài khoản cho khách hàng
                khachHangEntity.setTaiKhoanEntity(taiKhoanEntity1);
            }
        }
        System.out.println("tài khoản của kh: " + khachHangEntity.getTaiKhoanEntity());
        KhachHangEntity kh = khachHangService.add(khachHangEntity);

        appResponse = new AppResponseSuccess();
        appResponse.setData(kh);
        return appResponse;
    }

    // cập nhật
    @PostMapping(value = "/update-admin")
    @Transactional
    public AppResponse updateCustomerAdmin(@RequestBody AddCustomerRequest request) throws IOException {
        AppResponse appResponse;

        Integer id = request.getKhachHangEntity().getId();

        KhachHangEntity old = khachHangService.getById(id).get();
        KhachHangEntity newKH = request.getKhachHangEntity();

        // nếu ảnh mới khác ảnh cũ thì set lưu ảnh mới
        if (null != newKH.getImg() && !old.getImg().equals(newKH.getImg())){
            newKH.setImg(fileService.saveFileFullName(request.getImgBase64(), newKH.getImg()));
        }

        Integer idTaiKhoan = newKH.getTaiKhoanEntity().getId();
        System.out.println("id là" + idTaiKhoan);

        if (null != idTaiKhoan){
            Optional<TaiKhoanEntity> taiKhoanEntity = taiKhoanService.getById(idTaiKhoan);
            if (taiKhoanEntity.isPresent()){
                TaiKhoanEntity taiKhoanEntity1 = taiKhoanEntity.get();

                // cập nhật quyền là khách hàng cho tài khoản
                List<QuyenSuDungEntity> list = new ArrayList<>();
                list.add(quyenSuDungService.findById(2));
                taiKhoanEntity1.setQuyenSuDungEntities(list);

                taiKhoanEntity1 = taiKhoanService.updateAcc(taiKhoanEntity1);
                System.out.println("Tke"+ taiKhoanEntity1);

                // gán tài khoản cho khách hàng
                newKH.setTaiKhoanEntity(taiKhoanEntity1);
            }
        } else {
            newKH.setTaiKhoanEntity(null); // lỗi transient unsaved => Cascade
                                            // insert null cho @manytoone ( joincolumn nullable =true)
        }
        System.out.println("tài khoản của kh: " + newKH.getTaiKhoanEntity());
        KhachHangEntity kh = khachHangService.add(newKH);

        appResponse = new AppResponseSuccess();
        appResponse.setData(kh);
        return appResponse;
    }


    // lấy tất cả paging
    @GetMapping(value = "/delete/{id}")
    public AppResponse delete(@PathVariable Integer id){
        AppResponse appResponse;

//        KhachHangEntity khachHangEntity = khachHangService.findByIdTaiKhoan(id);
        KhachHangEntity khachHangEntity = khachHangService.getById(id).get();
        khachHangService.delete(khachHangEntity);

        appResponse = new AppResponseSuccess();
        return appResponse;
    }

    // lấy thông tin khách hàng
//    @PostMapping(value = "/get")
//    public AppResponse getCustomer(@RequestBody GetKhachHangRequest request) throws IOException {
//        System.out.println("nhận body: " + request.toString());
//        AppResponse appResponse;
//        if (request.getTypeAccount().equals("customer")){
//            KhachHangEntity khachHangEntity = khachHangService.getKhachHangByUserName(request.getUserName());
//
//            String imgBase64 = khachHangService.getImgBase64(khachHangEntity.getImg());
//            System.out.println("img baser 64: " + imgBase64);
//            KhachHangDTO khachHangDTO = new KhachHangDTO(khachHangEntity, imgBase64, "" );
//
//            appResponse = new AppResponseSuccess();
//            appResponse.setData(khachHangDTO);
//            return appResponse;
//        }
//
//        return  new AppResponseSuccess();
//
//    }

//    // cập nhật thông tin cá nhân
//    @PostMapping(value = "/update")
//    public AppResponse updateCustomer(@RequestBody UpdateInformationCustomerRequest request) {
//        System.out.println("nhận body: " + request.toString());
//        AppResponse appResponse;
//        KhachHangEntity khachHangEntity = khachHangService.updateCustomer(request);
//        if (null != khachHangEntity){
//            appResponse = new AppResponseSuccess();
//            appResponse.setData(khachHangEntity);
//            return appResponse;
//        }else {
//            appResponse = new AppResponseFailure();
//        }
//        return  new AppResponseSuccess();
//
//    }

    // cập nhật thông tin cá nhân
    @PostMapping(value = "/update")
    public AppResponse updateCustomer(@RequestBody UpdateInformationCustomerRequest request) throws IOException {
        AppResponse appResponse;

        KhachHangEntity khachHangEntity = khachHangService.updateCustomer(request);
        if (null != khachHangEntity){
            appResponse = new AppResponseSuccess();

            String imgBase64 = khachHangService.getImgBase64(khachHangEntity.getImg());
            KhachHangDTO khachHangDTO = new KhachHangDTO(khachHangEntity, imgBase64, "" );
            appResponse.setData(khachHangDTO);
            return appResponse;
        }else {
            appResponse = new AppResponseFailure();
        }
        return  appResponse;
    }

}
