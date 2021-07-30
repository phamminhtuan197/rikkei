package com.rikkei.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rikkei.dto.LoginInfoDto;
import com.rikkei.entity.Account;
import com.rikkei.service.IAccountService;


//Giải thích giống class AccountController

@RestController
@RequestMapping(value = "api/v1/login")
@CrossOrigin("*")
public class LoginController {
	@Autowired
	private IAccountService accountService;
	
	@GetMapping()
	public ResponseEntity<?> login(Principal principal) {    //Principal có thể hiểu là một người, hoặc một thiết bị, hoặc một hệ thống nào đó có thể thực hiện một hành động trong ứng dụng
		String userName = principal.getName();
		Account entity = accountService.getAccountByUserName(userName);
		
		LoginInfoDto dto = new LoginInfoDto(entity.getAccountID(), entity.getFullName());
		
		 return new ResponseEntity<LoginInfoDto>(dto, HttpStatus.OK);
	}
}
