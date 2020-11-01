package com.mta.shop.repository;

import com.mta.shop.entities.TaiKhoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoanEntity, Integer> {
    Optional<TaiKhoanEntity> findByTenDangNhap(String tenDangNhap);
}
