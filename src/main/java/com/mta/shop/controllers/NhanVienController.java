package com.mta.shop.controllers;

import com.mta.shop.controllers.message.AppResponse;
import com.mta.shop.controllers.message.AppResponseSuccess;
import com.mta.shop.controllers.message.nhanvien.AddNhanVienRequest;
import com.mta.shop.entities.NhanVienEntity;
import com.mta.shop.entities.QuyenSuDungEntity;
import com.mta.shop.entities.TaiKhoanEntity;
import com.mta.shop.service.NhanVienService;
import com.mta.shop.service.QuyenSuDungService;
import com.mta.shop.service.TaiKhoanService;
import com.mta.shop.service.mapper.NhanVienDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class NhanVienController {
    private final NhanVienService nhanVienService;
    private final TaiKhoanService taiKhoanService;
    private final QuyenSuDungService quyenSuDungService;

    // lấy tất cả dto
    @GetMapping(value = "/get-all-dto")
    public AppResponse getAllDTO(){
        AppResponse appResponse;

        List<NhanVienDTO> list = nhanVienService.getAllDTO();

        appResponse = new AppResponseSuccess();
        appResponse.setData(list);
        return appResponse;
    }

    // lấy tất cả
    @GetMapping(value = "/")
    public AppResponse getAllPaging(@RequestParam Integer pageNumber){
        AppResponse appResponse;

        Page<NhanVienEntity> nhanVienEntities = nhanVienService.getAllPaging(pageNumber);

        appResponse = new AppResponseSuccess();
        appResponse.setData(nhanVienEntities);
        return appResponse;
    }

    // thêm mới
    @PostMapping(value = "/add")
    @Transactional
    public AppResponse add(@RequestBody AddNhanVienRequest request){
        AppResponse appResponse;

        NhanVienEntity nhanVienEntity = request.getNhanVienEntity();

        Integer idTaiKhoan = nhanVienEntity.getTaiKhoanEntity().getId();
        System.out.println("id" + idTaiKhoan);

        if (null != idTaiKhoan){
            Optional<TaiKhoanEntity> taiKhoanEntity = taiKhoanService.getById(idTaiKhoan);
            if (taiKhoanEntity.isPresent()){
                TaiKhoanEntity taiKhoanEntity1 = taiKhoanEntity.get();

                // cập nhật quyền là khách hàng cho tài khoản
                List<QuyenSuDungEntity> list = new ArrayList<>();
                list.add(quyenSuDungService.findById(3));
                taiKhoanEntity1.setQuyenSuDungEntities(list);

                taiKhoanEntity1 = taiKhoanService.updateAcc(taiKhoanEntity1);
                System.out.println("Tke"+ taiKhoanEntity1);

                // gán tài khoản cho khách hàng
                nhanVienEntity.setTaiKhoanEntity(taiKhoanEntity1);
            }
        }
        System.out.println("tài khoản của kh: " + nhanVienEntity.getTaiKhoanEntity());
        NhanVienEntity nv = nhanVienService.saveOne(nhanVienEntity);

        appResponse = new AppResponseSuccess();
        appResponse.setData(nv);
        return appResponse;
    }

    // cập nhật
    @PostMapping(value = "/update-admin")
    @Transactional
    public AppResponse updateAdmin(@RequestBody AddNhanVienRequest request) throws IOException {
        AppResponse appResponse;

//        Integer id = request.getNhanVienEntity().getId();
//
//        NhanVienEntity old = nhanVienService.findOne(id).get();
        NhanVienEntity newNV = request.getNhanVienEntity();


        Integer idTaiKhoan = newNV.getTaiKhoanEntity().getId();
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
                newNV.setTaiKhoanEntity(taiKhoanEntity1);
            }
        } else {
            newNV.setTaiKhoanEntity(null); // lỗi transient unsaved => Cascade
                                            // insert null cho @manytoone ( joincolumn nullable =true)
        }
        System.out.println("tài khoản của kh: " + newNV.getTaiKhoanEntity());
        NhanVienEntity nv = nhanVienService.saveOne(newNV);

        appResponse = new AppResponseSuccess();
        appResponse.setData(nv);
        return appResponse;
    }

    // xóa
    @GetMapping(value = "/delete/{id}")
    public AppResponse delete(@PathVariable Integer id){
        AppResponse appResponse;

        nhanVienService.deleteById(id);

        appResponse = new AppResponseSuccess();
        return appResponse;
    }


}
