package com.rikkei.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.rikkei.service.UserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailService userDetailService;
	

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();

		http.authorizeRequests().antMatchers("/login", "/logout", "/register", "/home/**", "/cart/**",
				"/addCart/**", "/assets/**", "/css/**", "/js/**").permitAll();

		http.authorizeRequests().antMatchers("/customer/**").hasAnyAuthority("User");

		http.authorizeRequests().antMatchers("/admin/**").hasAnyAuthority("Admin");

		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");

		http.authorizeRequests().and().addFilterBefore(new JWTAuthenticationFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class);
		
		http.authorizeRequests().and().addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

	}



}
