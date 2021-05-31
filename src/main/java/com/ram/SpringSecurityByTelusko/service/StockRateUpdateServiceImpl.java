package com.ram.SpringSecurityByTelusko.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ram.SpringSecurityByTelusko.model.StockDetails;
import com.ram.SpringSecurityByTelusko.repository.UpdateStockRatesRepository;

@Service
public class StockRateUpdateServiceImpl implements StockRateUpdateService
{
   @Autowired
   private UpdateStockRatesRepository repository;
	public void updateStockRate() 
	{
		
		List<StockDetails>list=repository.findAll();
		if(list!=null)
		{
			
			int diff=0;
			for(StockDetails details:list)
			{
				int modifyBy=new Random().nextInt(100)-30;
				int rate=details.getRate();
				if(modifyBy>0)
				{
					int newRate=rate+modifyBy;
					System.out.println(newRate);
					diff=newRate-rate;
					details.setRate(newRate);
					details.setStatus("+"+diff);
					repository.save(details);
					
				}
				else
				{  
					int newRate=rate+(modifyBy);
					diff=newRate-rate;
					details.setRate(newRate);
					details.setStatus(""+diff);
					repository.save(details);
				}
				
			}
		}
	}
	
}
