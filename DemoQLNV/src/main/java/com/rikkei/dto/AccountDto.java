package com.rikkei.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

//Class này dùng để chuyển đổi giữa dữ liệu lấy được từ DB sang dữ hiển thị đẩy lên Frontend.
public class AccountDto {
	private short accountID;
	private String email;
	private String userName;
	private String fullName;
	private String department;
	private String position;
	
//	chỉ định định dạng khi serialization các giá trị Date/Time.
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createDate;

	public short getAccountID() {
		return accountID;
	}

	public void setAccountID(short accountID) {
		this.accountID = accountID;
	}

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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public AccountDto(short accountID, String email, String userName, String fullName, String department,
			String position, Date createDate) {
		super();
		this.accountID = accountID;
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.department = department;
		this.position = position;
		this.createDate = createDate;
	}

}
