package com.mta.shop.repository;

import com.mta.shop.entities.Star;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StarRepository extends JpaRepository<Star, Integer> {
    Optional<Star> findById(Integer id);
}
