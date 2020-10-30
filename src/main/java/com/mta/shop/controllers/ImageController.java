package com.mta.shop.controllers;

import com.mta.shop.controllers.message.AppResponse;
import com.mta.shop.controllers.message.AppResponseFailure;
import com.mta.shop.controllers.message.AppResponseSuccess;
import com.mta.shop.entities.ImagesEntity;
import com.mta.shop.repository.ImgRepositoryCustomImp;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {
    private final ImgRepositoryCustomImp imgRepositoryCustomImp;

    @GetMapping("/")
    public AppResponse getAllImagesByIdProduct(@RequestParam("idProduct") int idProduct, Model model){
        AppResponse appResponse;
        model.addAttribute("name", "Bùi văn chí");
        List<ImagesEntity> list = imgRepositoryCustomImp.getByProductId(idProduct);
        if (null != list){
            appResponse = new AppResponseSuccess();
            appResponse.setData(list);
        }else {
            appResponse = new AppResponseFailure();
            appResponse.setData(null);
        }
        return appResponse;
    }
}
