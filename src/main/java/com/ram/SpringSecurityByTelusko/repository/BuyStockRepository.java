package com.ram.SpringSecurityByTelusko.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ram.SpringSecurityByTelusko.model.StockDetails;

public interface BuyStockRepository extends JpaRepository<StockDetails, Integer> {

	StockDetails findByName(String name);

}
