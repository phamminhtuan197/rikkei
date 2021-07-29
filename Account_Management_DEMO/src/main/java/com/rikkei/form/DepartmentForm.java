package com.rikkei.form;

public class DepartmentForm {
	private String departmentName;

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public DepartmentForm(String departmentName) {
		super();
		this.departmentName = departmentName;
	}
	
}
