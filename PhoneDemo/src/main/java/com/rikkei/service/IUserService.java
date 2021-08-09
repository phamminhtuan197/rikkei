package com.rikkei.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.rikkei.entities.User;

public interface IUserService extends UserDetailsService {
	
Boolean existsByEmail(String email);
	
	User findByEmail(String email);
	
//	@Query(value = "select * from user where status = 1 and role = 0", nativeQuery = true)
	List<User> findByStatusTrueAndRoleFalse();
	
	//get admin
	List<User> findAllAdmin();
	//getUser
	List<User> findAllUser();
}
