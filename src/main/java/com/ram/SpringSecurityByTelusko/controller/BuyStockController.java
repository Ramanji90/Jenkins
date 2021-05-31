package com.ram.SpringSecurityByTelusko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ram.SpringSecurityByTelusko.model.StockDetails;
import com.ram.SpringSecurityByTelusko.service.BuyStockService;

@RestController
@RequestMapping(value="/api/stockmarket" )
public class BuyStockController 
{
	@Autowired
	   private BuyStockService service;
	   
	   @PostMapping(value="/buystock")
	   public ResponseEntity<String> buyStock(@RequestBody StockDetails stockDetails)
	   {
		   System.out.println(stockDetails);
		   String message=service.buyStock(stockDetails);
		   if(message!=null)
		   {
		   return new ResponseEntity<String>(message,HttpStatus.OK);
		   }
		   
		   return new ResponseEntity<String>("There is some problem ",HttpStatus.EXPECTATION_FAILED);
	   }

}
