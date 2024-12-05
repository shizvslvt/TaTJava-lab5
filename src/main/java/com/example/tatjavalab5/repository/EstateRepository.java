package com.example.tatjavalab5.repository;

import com.example.tatjavalab5.data.Estate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EstateRepository extends JpaRepository<Estate, Long> {
    List<Estate> findAllBySellerId(Long sellerId);

    List<Estate> findAllByRealtorId(Long realtorId);

}
