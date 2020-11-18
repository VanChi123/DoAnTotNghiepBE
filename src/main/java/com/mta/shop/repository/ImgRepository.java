package com.mta.shop.repository;

import com.mta.shop.entities.ImagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImgRepository extends JpaRepository<ImagesEntity, Integer> {
    List<ImagesEntity> getAllByIdSanPham(Integer idSanPham);
}
