package com.rikkei.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.rikkei.entity.User;

public interface IUserService extends UserDetailsService {
	
	Boolean existsByEmail(String email);
	
	User findByEmail(String email);
	
	void createUser(User user);
	
	void updateUser (long id, User user);
	
	void deleteUser (long id);
//	@Query(value = "select * from user where status = 1 and role = 0", nativeQuery = true)
//	List<User> findByStatusTrueAndRoleFalse();
	
	//get admin
	Page<User> findAllAdmin(Pageable pageable);
	//getUser
	Page<User> findAllUser(Pageable pageable);
}
