package com.rikkei.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rikkei.form.AccountFormForCreatingRegister;
import com.rikkei.service.IAccountService;

// Giải thích giống class AccountController, class này dùng để xử lí khi đăng ký account
@RestController
@RequestMapping(value = "api/v1/accountsRegister")
@CrossOrigin("*")
public class AccountRegisterController {

	@Autowired
	private IAccountService accountService;

	@PostMapping()
	public ResponseEntity<?> createAccount(@RequestBody AccountFormForCreatingRegister form) {
		accountService.createAccountRegister(form);
		return new ResponseEntity<String>("We have sent 1 email. Please check email to active account!",
				HttpStatus.CREATED);
	}

	@GetMapping("/activeUser")
	public ResponseEntity<?> activeUserViaEmail(@RequestParam String token) { //Kích hoạt tài khoản 

		// active user
		accountService.activeUser(token);

		return new ResponseEntity<>("Active success!", HttpStatus.OK);
	}

}
