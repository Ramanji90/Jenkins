/*package com.ram.SpringSecurityByTelusko.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ram.SpringSecurityByTelusko.model.User;
import com.ram.SpringSecurityByTelusko.repository.DAO;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private DAO dao;
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		User user=dao.findByUsername(username);
		if(user==null)
			throw new UsernameNotFoundException("User Not Found Exception");
		return new UserPrincipal(user);
	}

}
*/