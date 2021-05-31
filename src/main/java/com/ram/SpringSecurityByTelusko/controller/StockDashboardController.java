package com.ram.SpringSecurityByTelusko.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ram.SpringSecurityByTelusko.model.StockDetails;
import com.ram.SpringSecurityByTelusko.service.StockDashboardService;

@RestController
@RequestMapping()
public class StockDashboardController
{
	@Autowired
	private StockDashboardService service;
	
	@GetMapping(value="/getallstocks")
	public List<StockDetails> getAllStocks()
	{
		return service.getAllStocks();
	}

}
