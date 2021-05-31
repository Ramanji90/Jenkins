package com.ram.SpringSecurityByTelusko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ram.SpringSecurityByTelusko.model.StockDetails;
import com.ram.SpringSecurityByTelusko.service.SaleStocksService;

@RestController
@RequestMapping(value="/api/stockmarket" )
public class SaleStockController 
{
	@Autowired
	   private SaleStocksService service;
	   
	   @PostMapping(value="/salestock")
	   public ResponseEntity<String> buyStock(@RequestBody StockDetails stockDetails)
	   {
		   String message=service.saleStock(stockDetails);
		   if(message!=null)
		   {
		return new ResponseEntity<String>(message,HttpStatus.OK);
		   }
		   return new ResponseEntity<String>("There is problem",HttpStatus.EXPECTATION_FAILED);
		   
	   }

}
