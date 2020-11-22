package com.mta.shop.repository;

import com.mta.shop.entities.GiamGia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GiamGiaRepository extends JpaRepository<GiamGia, Integer> {
}
