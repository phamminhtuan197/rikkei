package com.rikkei.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration  // đánh dấu class này là nơi định nghĩa ra các bean
public class AuthenticationConfig {
	@Bean  //nằm trong class có đánh dấu @Còniguration, đánh dấu method này là Bean và cho phép spring boot đưa bean này vào context
	public PasswordEncoder passwordEncoder() {   //mã hoá password
		return new BCryptPasswordEncoder();
	}
}
