package com.mta.shop.repository;

import com.mta.shop.entities.ImagesEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImgRepositoryCustomImp {
    private final ImgRepository imgRepository;

    public List<ImagesEntity> getByProductId(int productId){
        return imgRepository.getAllByIdSanPham(productId);
    }
}
