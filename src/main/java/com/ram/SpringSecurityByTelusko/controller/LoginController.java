/*package com.ram.SpringSecurityByTelusko.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController
{
   @RequestMapping(value="/", method=RequestMethod.GET)
   public String Home()
   {
	   return "Home.jsp";
   }
   
   @RequestMapping("/login")
   public String loginPage()
   {
	   return "Login.jsp";
   }
   
   @RequestMapping("/Logout-success")
   public String logoutPage()
   {
	   return "Logout.jsp";
   }
   
   @RequestMapping("/user")
   //@ResponseBody
   public Principal user(Principal principal)
   {
	   return principal;
   }
}
*/