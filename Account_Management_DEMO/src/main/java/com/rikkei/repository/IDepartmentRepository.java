package com.rikkei.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rikkei.entity.Department;

//Extend JpaRepository của Spring data JPA, chỉ cần Extend mà k cần làm thêm gì, do 1 số phương thức hay dùng JPA đã hỗ trợ sẵn.
public interface IDepartmentRepository extends JpaRepository<Department, Short> {
	public Department findByDepartmentName(String departmentName);

	public boolean existsByDepartmentName(String departmentName);

}
