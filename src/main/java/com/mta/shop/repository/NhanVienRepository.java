package com.mta.shop.repository;

import com.mta.shop.entities.ImagesEntity;
import com.mta.shop.entities.NhanVienEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVienEntity, Integer> {
//    Optional<NhanVienEntity> findByIdTaiKhoan(Integer id);

    @Query(value = "select nv from NhanVienEntity nv where nv.taiKhoanEntity.id = :id")
    public NhanVienEntity findByIdTaiKhoan(@Param("id") Integer id);

}
