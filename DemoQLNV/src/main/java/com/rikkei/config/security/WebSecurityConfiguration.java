package com.rikkei.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.rikkei.service.IAccountService;


@Component   //đánh dấu class này là bean - giống với @service và @Repository
@EnableWebSecurity // đánh dấu class để kích hoạt SpringSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {  //WebSecurityConfigurerAdapter định nghĩa cấu hình cần thiết cho SpringSecurity
	@Autowired
	private IAccountService accountService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {   //AuthenticationManagerBuilder hỗ trợ sử dụng user được lưu trữ trong db
		auth.userDetailsService(accountService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {  //định nghĩa request nào được access bởi user có role nào
		http
		.cors()
		.and()
		.authorizeRequests()
		.antMatchers("/api/v1/accounts").hasAnyAuthority("Admin","Manager")
		.antMatchers("/api/v1/accounts/*").hasAnyAuthority("Admin","Manager")
		.anyRequest().authenticated()
		.and()
		.httpBasic()
		.and()
		.csrf().disable();
	}
}
