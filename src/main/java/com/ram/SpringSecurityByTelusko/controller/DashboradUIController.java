package com.ram.SpringSecurityByTelusko.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashboradUIController 
{
	@RequestMapping(value="/")
	public String displayDashboardUI()
	{
		//added comment
		return "Dashboard.jsp";
	}

}
