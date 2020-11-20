package com.mta.shop.repository;

import com.mta.shop.entities.BinhLuan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public interface BinhLuanRepository extends JpaRepository<BinhLuan, Integer> {
    // thêm mới bằng query: jpa ko hỗ trợ
    @Modifying // phải có cái này ko thì báo lỗi JpaSystemException: could not extract ResultSet
    // mặc định hàm thêm này thì trả về void nhé
    @Query(value = "insert into BinhLuan(IdTaiKhoan,IdSanPham,NgayGio, NoiDung, TenKhachHang, SoDienThoai) " +
            "values(:idTaiKhoan, :idSanPham, :ngayGio, :noiDung, :tenKhachHang, :soDienThoai)", nativeQuery = true)
    void addBinhLuan(@Param("idTaiKhoan") Integer idTaiKhoan,
                        @Param("idSanPham") Integer idSanPham,
                        @Param("ngayGio") Instant ngayGio,
                        @Param("noiDung") String noiDung,
                        @Param("tenKhachHang") String tenKhachHang,
                        @Param("soDienThoai") String soDienThoai);
}
