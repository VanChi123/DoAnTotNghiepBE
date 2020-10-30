package com.mta.shop.controllers;

import com.mta.shop.entities.SanPhamEntity;
import com.mta.shop.repository.SanPhamRepositoryCustomImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:8081/shop", maxAge = 3600)
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

    private final SanPhamRepositoryCustomImp sanPhamRepositoryCustomImp;

//    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SanPhamEntity> index() {

        System.out.println("ok" + sanPhamRepositoryCustomImp.findAllLoaiSanPham());
        List<SanPhamEntity> li = sanPhamRepositoryCustomImp.findAllLoaiSanPham();
        li.forEach(e -> {
                System.out.println(" e" +  e);
        });
        return sanPhamRepositoryCustomImp.findAllLoaiSanPham(); // Trả về file index.html
    }

    @GetMapping("/home")
    public String index1() {
        return "home"; // Trả về file index.html
    }
}
