package com.rikkei.service;

import java.util.List;

import com.rikkei.entity.Department;

public interface IDepartmentService {
//	public Page<Department> getAllDepartments(Pageable pageable);

	public List<Department> getAllDepartments();

	public Department getDepartmentByID(short departmentID);

	public Department getDepartmentByName(String departmentName);

	public void createDepartment(Department department);

	public boolean isDepartmentExistsByID(short departmentID);

	public boolean isDepartmentExistsByName(String departmentName);

	public void updateDepartment(Department department);

	public void deleteDepartment(short departmentID);
}
