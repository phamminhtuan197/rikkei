package com.rikkei.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.rikkei.entity.RegistrationUserToken;

public interface IRegistrationUserTokenRepository extends JpaRepository<RegistrationUserToken, Integer> {
	
	public RegistrationUserToken findByToken(String token);

	public boolean existsByToken(String token);

	@Query(" SELECT token FROM RegistrationUserToken WHERE user_id =:accountID")  //cấu hình phương thức theo câu query này, sử dụng các đối tượng trong java chứ không phải các trường tỏng db
	public String findByUserId(int accountID);

	@Transactional   //đánh dấu phương thức này khi thực thi sẽ nằm trong transaction context
	@Modifying   //đánh dấu phương thức này là 1 câu truy vấn để cập nhật db 
	@Query(" DELETE FROM RegistrationUserToken WHERE user_id =:userId")
	public void deleteByUserId(int userId);

}
