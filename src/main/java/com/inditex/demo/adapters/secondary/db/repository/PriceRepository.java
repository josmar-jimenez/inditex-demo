package com.inditex.demo.adapters.secondary.db.repository;

import com.inditex.demo.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price,String>{

    @Query("SELECT p FROM Price p WHERE p.brandId=:brandId AND p.productId=:productId AND p.startDate<=:applicationDate "
            + "AND (p.endDate>=:applicationDate OR p.endDate IS NULL) ORDER BY p.priority DESC")
    List<Price> findActualPriceByBrandIdAndProductId(int brandId,int productId, OffsetDateTime applicationDate);
}
