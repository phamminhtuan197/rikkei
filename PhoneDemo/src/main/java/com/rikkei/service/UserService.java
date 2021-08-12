package com.rikkei.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rikkei.entity.User;
import com.rikkei.repository.IRegistrationUserTokenRepository;
import com.rikkei.repository.UserRepository;

public class UserService implements IUserService{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	@Autowired
	private IRegistrationUserTokenRepository registrationUserTokenRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException(email);
		}

		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				AuthorityUtils.createAuthorityList(user.getRole().toString()));
	}

	@Override
	public Boolean existsByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.existsByEmail(email);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public List<User> findByStatusTrueAndRoleFalse() {
		// TODO Auto-generated method stub
		return userRepository.findByStatusTrueAndRoleFalse();
	}

	@Override
	public List<User> findAllAdmin() {
		// TODO Auto-generated method stub
		return userRepository.findAllAdmin();
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return findAllUser();
	}
	
	

}
