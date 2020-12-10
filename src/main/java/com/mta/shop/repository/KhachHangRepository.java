package com.mta.shop.repository;

import com.mta.shop.entities.KhachHangEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHangEntity, Integer> {
//    KhachHangEntity findByIdTaiKhoan(int idTaiKhoan);
    @Query(value = "select kh from KhachHangEntity kh where kh.taiKhoanEntity.id = :id")
    KhachHangEntity findByIdTaiKhoan(Integer id);
}
