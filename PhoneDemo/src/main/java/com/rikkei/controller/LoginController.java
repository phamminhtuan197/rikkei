package com.rikkei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rikkei.entity.Login;
import com.rikkei.entity.User;
import com.rikkei.repository.UserRepository;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class LoginController {
	@Autowired
	UserRepository repo;
	
	@RequestMapping("admin/login")
	public ResponseEntity<User> LoginAdmin(@RequestBody Login login) {
		User u = new User();
		boolean checkUsername = false;
		List<User> listU = repo.findAllAdmin();
		for(User user: listU){
			if(login.getUsername().equals(user.getEmail())) {
				checkUsername = true;
				u = repo.findByEmail(login.getUsername());
				if(u.getPassword().equals(login.getPassword())) {
					return ResponseEntity.ok(u);
				}
			}
		}
		if(!checkUsername) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.badRequest().build();
	}
	
	@RequestMapping("user/login")
	public ResponseEntity<User> LoginUser(@RequestBody Login login) {
		User u = new User();
		boolean checkUsername = false;
		List<User> listU = repo.findAllUser();
		System.out.println(listU.size());
		for(User user: listU){
			if(login.getUsername().equals(user.getEmail())) {
				checkUsername = true;
				u = repo.findByEmail(login.getUsername());
				if(u.getPassword().equals(login.getPassword())) {
					return ResponseEntity.ok(u);
				}
			}
		}
		if(!checkUsername) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.badRequest().build();
	}
}
