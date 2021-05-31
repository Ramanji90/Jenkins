package com.ram.SpringSecurityByTelusko.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ram.SpringSecurityByTelusko.model.StockDetails;
import com.ram.SpringSecurityByTelusko.repository.SaleStockRepository;

@Service
public class SaleStocksServiceImpl implements SaleStocksService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Autowired
	
	private SaleStockRepository repository;

		StockDetails fromDB=null;
	public String saleStock(StockDetails stockDetails)
	{
		do
		{
			fromDB=repository.findByName(stockDetails.getName());
		}
		while(stockDetails.getRate()!=fromDB.getRate());
		
		fromDB.setQuantity(fromDB.getQuantity()+stockDetails.getQuantity());
		
		boolean isSent=sendSimpleEmail();
		if(isSent==true)
		{
			repository.save(fromDB);
			return "\"Dear Customer There is big PriceUp in the stock market\"";
		}
		return "There is problem in sending an Email";
	}
	
	public boolean sendSimpleEmail()
	{
		SimpleMailMessage message= new SimpleMailMessage();
		message.setTo("Ramanjaneyappa@gmail.com");
		message.setSubject("Dear Customer There is big PriceUp in the stock market");
		message.setText("Dear Customer there is price drop in the stock market"
				+ "\n Be the Firstone to grab the stock before going out of stock ");
		javaMailSender.send(message);
		return true;
	}
	
	public boolean sendEmailWithAttachment() throws MessagingException
	{
		MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		
        helper.setTo("siva6ganesh94vs@gmail.com");

        helper.setSubject("Email notification from Spring Boot");

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html
        helper.setText("<h1>Check attachment !</h1>", true);

		// hard coded a file path
        FileSystemResource file = new FileSystemResource(new File("E:\\Rama\\user.jpg"));
        //helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));
        
        helper.addAttachment(file.getFilename(),file);

        javaMailSender.send(msg);
		return true;
	}

}
