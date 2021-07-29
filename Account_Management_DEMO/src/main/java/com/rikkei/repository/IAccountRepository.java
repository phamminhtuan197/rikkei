package com.rikkei.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.rikkei.entity.Account;


public interface IAccountRepository extends JpaRepository<Account, Short>, JpaSpecificationExecutor<Account> {
	public Account findByUserName(String userName);
	
	public Account findByEmail(String email);

	public boolean existsByUserName(String userName);
	
	public boolean existsByEmail(String email);
}
