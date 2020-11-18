package com.mta.shop.repository;

import com.mta.shop.entities.SanPhamEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPhamEntity, Integer> {
    List<SanPhamEntity> findAll();

    // tìm kiếm sản phẩm admin
    @Query( value = "SELECT sp FROM SanPhamEntity sp where" +
            "  (:maSanPham is null or lower(sp.maSanPham) like concat('%',lower(:maSanPham),'%'))" +
            "and (:tenSanPham is null or lower(sp.tenSanPham) like concat('%',lower(:tenSanPham),'%'))" +
            "and (sp.loaiSanPham.id in :loaiSanPham)"+
            "and (sp.thuongHieuEntity.id in :thuongHieu)"+
            "and (:priceLower is null or sp.gia >= :priceLower)"+
            "and (:priceUpper is null or sp.gia <= :priceUpper)"
    )
    Page<SanPhamEntity> searchAdminPaging(Pageable pageable,
                                          @Param("tenSanPham") String tenSanPham,
                                          @Param("maSanPham") String maSanPham,
                                          @Param("loaiSanPham") List<Integer> loaiSanPham,
                                          @Param("thuongHieu") List<Integer> thuongHieu,
                                          @Param("priceLower") Float priceLower,
                                          @Param("priceUpper") Float priceUpper );

    @Query("select s from SanPhamEntity s " +
            "where (:tenSanPham is null or s.tenSanPham like concat('%',:tenSanPham,'%'))")
    List<SanPhamEntity> searchProduct(@Param("tenSanPham") String tenSanPham);


                                        //lấy list sản phẩm theo phân trang // ở đây ko dùng gì cả nhé
//    List<SanPhamEntity> findByPaging(int pageSize, int pageNumber);

    // lấy 1 sản phẩm theo mã
    @Query( value = "SELECT * FROM SanPham sp where sp.MaSanPham = :maSanPham", nativeQuery=true)
    public Optional<SanPhamEntity> findByMaSanPham(@Param("maSanPham") String maSanPham);
}


