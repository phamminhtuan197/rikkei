package com.rikkei.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rikkei.entity.Gender;

public class UserDto {
	private short id;
	private String email;
	private String username;
	private String name;
	private Gender gender;
	private String address;
	private String phone;
	private String image;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date registerDate;
	public short getId() {
		return id;
	}
	public void setId(short id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public UserDto(short id, String email, String username, String name, Gender gender, String address, String phone,
			String image, Date registerDate) {
		super();
		this.id = id;
		this.email = email;
		this.username = username;
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
		this.image = image;
		this.registerDate = registerDate;
	}
	public UserDto() {
		super();
	}
	
	
}
