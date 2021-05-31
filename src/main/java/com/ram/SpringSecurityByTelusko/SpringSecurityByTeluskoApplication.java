package com.ram.SpringSecurityByTelusko;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.ram.SpringSecurityByTelusko.service.StockRateUpdateServiceImpl;

@SpringBootApplication
@EnableScheduling
public class SpringSecurityByTeluskoApplication implements CommandLineRunner{

	@Autowired
	private StockRateUpdateServiceImpl service;
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityByTeluskoApplication.class, args);
	}

	public void run(String... args) throws Exception 
	{
		
		//stockRateUpdateScheduler();
	}
	
	/*@Scheduled(fixedDelay=3000)
	public void stockRateUpdateScheduler()
	{
		service.updateStockRate();
	}*/
	

}
