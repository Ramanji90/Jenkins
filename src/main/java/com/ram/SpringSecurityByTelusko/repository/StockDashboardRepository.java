package com.ram.SpringSecurityByTelusko.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ram.SpringSecurityByTelusko.model.StockDetails;

public interface StockDashboardRepository extends JpaRepository<StockDetails, Integer>{

}
