package com.rikkei.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@SuppressWarnings("serial")
public class Statistical implements Serializable{
	private int month;
	private Date date;
	private Double amount;
	private BigInteger count;
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public BigInteger getCount() {
		return count;
	}
	public void setCount(BigInteger count) {
		this.count = count;
	}
	public Statistical(int month, Date date, Double amount, BigInteger count) {
		super();
		this.month = month;
		this.date = date;
		this.amount = amount;
		this.count = count;
	}
	public Statistical() {
		super();
	}
	
	
}
