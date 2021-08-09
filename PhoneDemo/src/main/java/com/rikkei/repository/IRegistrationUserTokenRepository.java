package com.rikkei.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.rikkei.entities.RegistrationUserToken;

public interface IRegistrationUserTokenRepository extends JpaRepository<RegistrationUserToken, Integer> {
	
	public RegistrationUserToken findByToken(String token);

	public boolean existsByToken(String token);

	@Query(" SELECT token FROM RegistrationUserToken WHERE user_id =:user_id")  
	public String findByUserId(int userId);

	@Transactional   
	@Modifying   
	@Query(" DELETE FROM RegistrationUserToken WHERE user_id =:user_id")
	public void deleteByUserId(int userId);

}
