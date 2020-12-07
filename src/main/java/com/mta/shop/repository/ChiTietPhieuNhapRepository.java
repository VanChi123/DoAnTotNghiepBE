package com.mta.shop.repository;

import com.mta.shop.entities.ChiTietPhieuNhap;
import com.mta.shop.entities.ChiTietPhieuNhapPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietPhieuNhapRepository extends JpaRepository<ChiTietPhieuNhap, ChiTietPhieuNhapPK> {
}
