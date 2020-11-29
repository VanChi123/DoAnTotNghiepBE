package com.mta.shop.controllers;

import com.mta.shop.controllers.message.*;
import com.mta.shop.controllers.message.taikhoan.*;
import com.mta.shop.entities.SanPhamEntity;
import com.mta.shop.entities.Star;
import com.mta.shop.entities.TaiKhoanEntity;
import com.mta.shop.repository.TaiKhoanRepository;
import com.mta.shop.repository.TaiKhoanRepositoryCustom;
import com.mta.shop.service.SanPhamService;
import com.mta.shop.service.TaiKhoanService;
import com.mta.shop.service.mapper.SanPhamDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/account")
@RequiredArgsConstructor
public class TaiKhoanController {

    private final TaiKhoanRepositoryCustom taiKhoanRepositoryCustom;
    private final TaiKhoanService taiKhoanService;
    private final TaiKhoanRepository taiKhoanRepository;
    private final SanPhamService sanPhamService;

    // lấy tất cả
    @GetMapping("/")
    public AppResponse getAll() {
        List<TaiKhoanEntity> list = taiKhoanRepository.findAll();

        AppResponse appResponse = new AppResponseSuccess();
        appResponse.setData(list);
        return appResponse;
    }

    // thêm mới tài khoản
    @PostMapping("/add")
    public AppResponse forgotPassword(@RequestBody AddAccountRequest request) throws MessagingException {
        System.out.println("request:" + request);
        TaiKhoanEntity taiKhoanEntity;
        if (request.getTypeAccount().equals("customer")) {
            taiKhoanEntity = taiKhoanRepositoryCustom.addCustomer(new TaiKhoanEntity(request.getUserName(), request.getPassword(), request.getEmail()));
        } else {
            taiKhoanEntity = taiKhoanRepositoryCustom.addEmployee(new TaiKhoanEntity(request.getUserName(), request.getPassword(), request.getEmail()));
        }
        AppResponse appResponse = new AppResponseSuccess();
        appResponse.setData(taiKhoanEntity);
        return appResponse;
    }

    // đổi mật khẩu
    @PostMapping("/change-password")
    public AppResponse updatePassword(@RequestBody UpdatePassword request) {
        System.out.println("request:" + request);
        AppResponse appResponse;
        TaiKhoanEntity taiKhoanEntity = taiKhoanService.updatePassword(request);
        if (null != taiKhoanEntity) {
            appResponse = new AppResponseSuccess();
            appResponse.setData(taiKhoanEntity);
        } else {
            appResponse = new AppResponseFailure();
        }
        return appResponse;
    }

    // test: lấy tài khoản theo tên đăng nhập  :truyền theo kiểu path variable , khác với @request parram thì ko cần khai báo {{}}
//    @RequestMapping("profiles/{userName}")
//    public String handleRequest2 (@PathVariable String userName, Model model) {
//        model.addAttribute("msg", "user profile name : " + userName);
//        return "my-page";
//    }
    @PostMapping("/get-account/{id}")
    public TaiKhoanEntity testGetTaiKhoan( @PathVariable("id") String name) {
        System.out.println("request:" + name);
        AppResponse appResponse;
        TaiKhoanEntity taiKhoanEntity = taiKhoanRepository.findByTenDangNhap(name).get();
        System.out.println("ket quR "  + taiKhoanEntity);
        if (null != taiKhoanEntity) {
            appResponse = new AppResponseSuccess();
            appResponse.setData(taiKhoanEntity);
        } else {
            appResponse = new AppResponseFailure();
        }
        return taiKhoanEntity;
    }

    // ok: get all tài khoản admin
    @PostMapping("/get-all")
    public AppResponse testGetTaiKhoan(@RequestBody GetAccountListRequest request) {
        System.out.println("request:" + request);
        AppResponse appResponse;
        Page<TaiKhoanEntity> response = taiKhoanService.getAllAccount(request);

        if (null != response){
            appResponse = new AppResponseSuccess();
            appResponse.setData(response);
        }else {
            appResponse = new AppResponseFailure();
        }
        return  appResponse;
    }

    // ok: thêm mới tài khoản (admin)
    @PostMapping("/add/many-roles")
    public AppResponse addAccountManyRoles(@RequestBody AddAccountManyRoleRequest request) {
        System.out.println("request:" + request);
        AppResponse appResponse;

        TaiKhoanEntity taiKhoanEntityAfterAdd = taiKhoanService.addAcountManyRoles(request);
        System.out.println("ket quR "  + taiKhoanEntityAfterAdd);
        if (null != taiKhoanEntityAfterAdd) {
            appResponse = new AppResponseSuccess();
            appResponse.setData(taiKhoanEntityAfterAdd);
        } else {
            appResponse = new AppResponseFailure();
        }
        return appResponse;
    }

    // ok: cập nhật tài khoản (admin)
    @PostMapping("/update/many-roles")
    public AppResponse updateAccountManyRoles(@RequestBody AddAccountManyRoleRequest request) {
        System.out.println("request:" + request);
        AppResponse appResponse;

        TaiKhoanEntity taiKhoanEntityAfterAdd = taiKhoanService.updateAcountManyRoles(request);
        System.out.println("ket quR "  + taiKhoanEntityAfterAdd);
        if (null != taiKhoanEntityAfterAdd) {
            appResponse = new AppResponseSuccess();
            appResponse.setData(taiKhoanEntityAfterAdd);
        } else {
            appResponse = new AppResponseFailure();
        }
        return appResponse;
    }

    // ok: xóa tài khoản (admin)
    @PostMapping("/delete/many-roles")
    public AppResponse deleteAccountManyRoles(@RequestBody DeleteAccountManyRoleRequest request) {
        System.out.println("request:" + request);
        AppResponse appResponse;

        Boolean result = taiKhoanService.deleteAcountManyRoles(request);
//        System.out.println("ket quR "  + taiKhoanEntityAfterAdd);
        if (true == result) {
            appResponse = new AppResponseSuccess();
            appResponse.setData(true);
        } else {
            appResponse = new AppResponseFailure();
            appResponse.setData(false);
        }
        return appResponse;
    }

    // Lấy danh sách snar phẩm yêu thích của tài khoản
    @PostMapping("/get-list-favorite")
    public AppResponse getListFavorite(@RequestBody GetFavoriteListByAccountRequest request) {
        System.out.println("request:" + request);

        Optional<TaiKhoanEntity> taiKhoanEntity = taiKhoanService.getAccountByTenDangNhap(request.getTenDangNhap());
        AppResponse appResponse;
        if (taiKhoanEntity.isPresent()){

            appResponse = new AppResponseSuccess();

            List<SanPhamEntity> sanPhamEntities = taiKhoanEntity.get().getSanPhamEntities();

            List<SanPhamDTO> li = sanPhamEntities.stream().map(e -> {
                try {
                    return new SanPhamDTO(e, sanPhamService.getImgBase64(e.getAnhDaiDien()), "");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    return null; // phải có return cho thằng catch
                }
            }).collect(Collectors.toList());
            appResponse.setData(li);
            // appResponse.setData(taiKhoanEntity.get().getFavorites());
        }else {
            appResponse = new AppResponseFailure();
        }
        return appResponse;
    }

    // yêu thích sản phẩm or ko yêu thích
    // Lấy danh sách snar phẩm yêu thích của tài khoản
    @PostMapping("/favorite")
    public AppResponse getListFavorite(@RequestBody FavoriteOrUnFavorityRequest request) {
        System.out.println("request:" + request);
        AppResponse appResponse;

        SanPhamEntity sanPhamEntity = taiKhoanService.favorite(request);
        if (null != sanPhamEntity){
            appResponse = new AppResponseSuccess();
        }else {
            appResponse = new AppResponseFailure();
        }
        return appResponse;
    }
}
