package com.mta.shop.repository;

import com.mta.shop.entities.QuyenSuDungEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuyenSuDungRepository extends JpaRepository<QuyenSuDungEntity, Integer> {
}
