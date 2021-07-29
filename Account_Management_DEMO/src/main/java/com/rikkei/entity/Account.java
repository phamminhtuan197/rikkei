package com.rikkei.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "Account", catalog = "TestingSystem")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "AccountID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short accountID;
	@Column(name = "Email", length = 50, nullable = false, unique = true)
	private String email;
	@Column(name = "Username", length = 50, nullable = false, unique = true)
	private String userName;
	@Column(name = "FullName", length = 50, nullable = false)
	private String fullName;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DepartmentID", nullable = false)
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	private Department department;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PositionID", nullable = false)
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	private Position position;
	@Column(name = "CreateDate")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;


	public Account(String email, String userName, String fullName, Department department, Position position) {
		super();
		this.email = email;
		this.userName = userName;
		this.fullName = fullName;
		this.department = department;
		this.position = position;
	}

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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Account() {
		super();
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", email=" + email + ", userName=" + userName + ", fullName="
				+ fullName + ", department=" + department.getDepartmentName() + ", position="
				+ position.getPositionName() + ", createDate=" + createDate + "]";
	}

}
