package com.ram.SpringSecurityByTelusko.appsecurityconfig;


import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class AppSecurityConfig extends WebSecurityConfigurerAdapter
{
	
	protected void configure(HttpSecurity http) throws Exception
	{
		http
	      .antMatcher("/**")
	      .authorizeRequests()
	        .antMatchers("/", "/getallstocks")
	        .permitAll()
	      .anyRequest()
	        .authenticated();
	
		
		
		
	}
}
