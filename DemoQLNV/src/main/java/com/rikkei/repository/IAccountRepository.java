package com.rikkei.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.rikkei.entity.Account;

//Extends JpaRepository của Spring data JPA, chỉ cần Extend mà k cần làm thêm gì, do 1 số phương thức hay dùng JPA đã hỗ trợ sẵn.
//Extends JPASpecificationExcutor để hỗ trợ tìm kiếm Specification
public interface IAccountRepository extends JpaRepository<Account, Short>, JpaSpecificationExecutor<Account> {
	public Account findByUserName(String userName);
	
	public Account findByEmail(String email);

	public boolean existsByUserName(String userName);
	
	public boolean existsByEmail(String email);
}
