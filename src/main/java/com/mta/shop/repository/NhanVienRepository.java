package com.mta.shop.repository;

import com.mta.shop.entities.ImagesEntity;
import com.mta.shop.entities.NhanVienEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVienEntity, Integer> {
    public Optional<NhanVienEntity> findByIdTaiKhoan(Integer id);
}
