package com.ram.SpringSecurityByTelusko.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ram.SpringSecurityByTelusko.model.User;

public interface DAO extends JpaRepository<User, Integer> {

	User findByUsername(String username);

}
