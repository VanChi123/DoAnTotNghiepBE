package com.mta.shop.repository;

import com.mta.shop.entities.TaiKhoanEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoanEntity, Integer> {
    Optional<TaiKhoanEntity> findByTenDangNhap(String tenDangNhap);

//    @Query("select t from TaiKhoanEntity t " +
//            "where (:tenDangNhap is null or t.tenDangNhap like concat('%',:tenDangNhap,'%'))" +
//            "and (:email is null or t.email like concat('%',:email,'%'))" +
//            " and (t.quyenSuDungEntities in (:quyenSuDung))" order by  xxx"
//    )
//    Page<TaiKhoanEntity> searchViolatesByAdmin(Pageable pageable,
//                                               @Param("tenDangNhap") String tenDangNhap,
//                                               @Param("email") String email,
//                                               @Param("quyenSuDung") List<Integer> quyenSuDung);

    @Query("select t from TaiKhoanEntity t " +
            "where (:tenDangNhap is null or t.tenDangNhap like concat('%',:tenDangNhap,'%'))" +
            "and (:email is null or t.email like concat('%',:email,'%'))"
    )
    Page<TaiKhoanEntity> searchAllAccount(Pageable pageable,
                                               @Param("tenDangNhap") String tenDangNhap,
                                               @Param("email") String email);

//    @Query("select t from TaiKhoanEntity t " +
//            " WHERE t.tenDangNhap LIKE CONCAT('%',:tenDangNhap,'%')" +
//            " and t.email LIKE CONCAT('%',:email,'%')")
//            "and (:email is null or t.email like concat('%',:email,'%'))"
//    )
//    Page<TaiKhoanEntity> searchAllAccount(Pageable pageable,
//                                               @Param("tenDangNhap") String tenDangNhap,
//                                               @Param("email") String email);
//                                               @Param("quyenSuDung") List<Integer> quyenSuDung);
}
