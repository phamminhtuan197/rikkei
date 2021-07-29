package com.rikkei.dto;

//Class này dùng để chuyển đổi giữa dữ liệu lấy được từ DB sang dữ hiển thị đẩy lên Frontend.
public class DepartmentDto {

	private short departmentID;

	private String departmentName;

	public short getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(short departmentID) {
		this.departmentID = departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public DepartmentDto(short departmentID, String departmentName) {
		super();
		this.departmentID = departmentID;
		this.departmentName = departmentName;
	}

}
