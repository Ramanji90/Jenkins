package com.ram.SpringSecurityByTelusko.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.SpringSecurityByTelusko.model.StockDetails;
import com.ram.SpringSecurityByTelusko.repository.StockDashboardRepository;

@Service
public class StockDashboardServiceImpl implements StockDashboardService
{
	@Autowired
	private StockDashboardRepository repository;

	public List<StockDetails> getAllStocks() 
	{
		 return repository.findAll();
	}
	


}
