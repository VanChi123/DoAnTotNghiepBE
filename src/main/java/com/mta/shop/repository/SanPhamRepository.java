package com.mta.shop.repository;

import com.mta.shop.entities.SanPhamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPhamEntity, Integer> {
    List<SanPhamEntity> findAll();

    @Query("select s from SanPhamEntity s " +
            "where (:tenSanPham is null or s.tenSanPham like concat('%',:tenSanPham,'%'))")
    List<SanPhamEntity> searchProduct(@Param("tenSanPham") String tenSanPham);


                                        //lấy list sản phẩm theo phân trang // ở đây ko dùng gì cả nhé
//    List<SanPhamEntity> findByPaging(int pageSize, int pageNumber);

    // lấy 1 sản phẩm theo mã
    @Query( value = "SELECT * FROM SanPham sp where sp.MaSanPham = :maSanPham", nativeQuery=true)
    public Optional<SanPhamEntity> findByMaSanPham(@Param("maSanPham") String maSanPham);
}


