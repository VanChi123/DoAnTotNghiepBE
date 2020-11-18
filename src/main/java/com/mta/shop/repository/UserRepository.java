package com.mta.shop.repository;

import com.mta.shop.entities.TaiKhoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<TaiKhoanEntity, Integer> {
    @Query("from TaiKhoanEntity tk where tk.tenDangNhap = :tenDangNhap and tk.matKhau = :matKhau")
    Optional<TaiKhoanEntity> findByTenDangNhapAndMatKhau(@Param("tenDangNhap") String tenDangNhap,
                                                         @Param("matKhau") String matKhau);
}
