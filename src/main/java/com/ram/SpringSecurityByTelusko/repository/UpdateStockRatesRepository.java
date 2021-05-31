package com.ram.SpringSecurityByTelusko.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ram.SpringSecurityByTelusko.model.StockDetails;

public interface UpdateStockRatesRepository extends JpaRepository<StockDetails, Integer>
{

}
