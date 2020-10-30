package com.mta.shop.repository;

import com.mta.shop.entities.SanPhamEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SanPhamRepositoryCustomImp {
    private final SanPhamRepository sanPhamRepository;

    public List<SanPhamEntity> findAllLoaiSanPham(){
        int a = 3;
        int b = a +5;
        return sanPhamRepository.findAll();
    }

    // lấy danh sách sản phẩm
    public Page<SanPhamEntity> findProductsPaging(int pageNumber, int pageSize){
        Pageable paging = PageRequest.of(pageNumber, pageSize);
        Page<SanPhamEntity> pagedResult = sanPhamRepository.findAll(paging);

        return pagedResult;
    }

    // tìm kiếm sản phẩm theo tên sản phẩm
    public Page<SanPhamEntity> findProductsPaging(int pageNumber, int pageSize, String nameProduct){
        Pageable paging = PageRequest.of(pageNumber, pageSize);
        List<SanPhamEntity> list = sanPhamRepository.searchProduct(nameProduct);
        int count = list.size();

        int start = Math.min((int) paging.getOffset(), count);
        int end = Math.min((start + paging.getPageSize()), count);

        Page<SanPhamEntity> pagedResult = new PageImpl<>(list.subList(start, end), paging, count);

        return pagedResult;
    }

    public SanPhamEntity findProductByMaSanPham(String maSanPham){
        Optional<SanPhamEntity> sanPhamEntityOpt = sanPhamRepository.findByMaSanPham(maSanPham);

        if (sanPhamEntityOpt.isPresent()){
            SanPhamEntity sanPhamEntity = sanPhamEntityOpt.get();
            return sanPhamEntity;
        }

        return null;
    }
}
