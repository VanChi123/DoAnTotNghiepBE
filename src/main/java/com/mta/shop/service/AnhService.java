package com.mta.shop.service;

import com.mta.shop.entities.ThuongHieuEntity;
import com.mta.shop.repository.ImgRepository;
import com.mta.shop.repository.ThuongHieuRepository;
import com.mta.shop.service.mapper.AnhDTO;
import com.mta.shop.service.utils.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnhService {
    @Autowired
    private ImgRepository imgRepository;

    @Autowired
    private FileService fileService;

    public List<AnhDTO> getAllByIdSanPham(Integer productId){
        return imgRepository.getAllByIdSanPham(productId).stream().map(e -> {
            try {
                return new AnhDTO(e, fileService.getFile(e.getTenAnh()));
            } catch (IOException ioException) {
                ioException.printStackTrace();
                return null;
            }
        }).collect(Collectors.toList());
    }

}
