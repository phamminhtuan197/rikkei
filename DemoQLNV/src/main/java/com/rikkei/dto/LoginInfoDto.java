package com.rikkei.dto;

public class LoginInfoDto {
	private short accountID;
	private String fullName;

	public LoginInfoDto(short accountID, String fullName) {
		super();
		this.accountID = accountID;
		this.fullName = fullName;
	}

	public short getAccountID() {
		return accountID;
	}

	public void setAccountID(short accountID) {
		this.accountID = accountID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String toString() {
		return "LoginInfoDto [accountID=" + accountID + ", fullName=" + fullName + "]";
	}

}
