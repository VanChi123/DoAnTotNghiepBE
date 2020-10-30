package com.mta.shop.repository;

import com.mta.shop.entities.KhachHangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHangEntity, Integer> {
    KhachHangEntity findByIdTaiKhoan(int idTaiKhoan);
}
