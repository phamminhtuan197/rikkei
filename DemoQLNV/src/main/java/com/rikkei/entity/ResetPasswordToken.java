package com.rikkei.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "`Reset_Password_Token`", catalog = "TestingSystem")
public class ResetPasswordToken implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "`id`")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "`token`", length = 40, nullable = false, unique = true)
	private String token;

	@OneToOne(targetEntity = Account.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "`user_id`", nullable = false)
	private Account account;

	@Column(name = "`expiryDate`", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date expiryDate;

	public ResetPasswordToken() {
		super();
	}

	public ResetPasswordToken(String token, Date expiryDate) {
		super();
		this.token = token;
		this.expiryDate = expiryDate;

		expiryDate = new Date(System.currentTimeMillis() + 1000 * 60 * 60);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

}
