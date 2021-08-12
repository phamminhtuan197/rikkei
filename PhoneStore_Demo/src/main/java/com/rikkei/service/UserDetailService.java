package com.rikkei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rikkei.entity.Customer;
import com.rikkei.repository.CustomerRepository;

@Service
public class UserDetailService implements UserDetailsService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Customer customer = customerRepository.FindByEmail(email).get();

		if (customer== null) {
			System.out.println("Email not found! " + email);
			throw new UsernameNotFoundException("Email: " + email + " was not found in the database");
		}

		return new User(customer.getEmail(), customer.getPassword(), AuthorityUtils.createAuthorityList(customer.getRole().toString()));
	}
}
