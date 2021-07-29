package com.rikkei.form;

public class AccountForm {
	private String email;
	private String userName;
	private String fullName;
	private short departmentID;
	private short positionID;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public short getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(short departmentID) {
		this.departmentID = departmentID;
	}

	public short getPositionID() {
		return positionID;
	}

	public void setPositionID(short positionID) {
		this.positionID = positionID;
	}

	public AccountForm(String email, String userName, String fullName, short departmentID, short positionID) {
		super();
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.departmentID = departmentID;
		this.positionID = positionID;
	}

	public AccountForm() {
		super();
	}
	
}
