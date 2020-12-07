package com.mta.shop.repository;

import com.mta.shop.entities.ThuongHieuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThuongHieuRepository extends JpaRepository<ThuongHieuEntity, Integer> {
    @Query("select th.id from ThuongHieuEntity th")
    public List<Integer> getAllId();
}
