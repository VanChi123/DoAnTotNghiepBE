package com.mta.shop.repository;

import com.mta.shop.entities.BinhLuan;
import com.mta.shop.entities.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {
}
