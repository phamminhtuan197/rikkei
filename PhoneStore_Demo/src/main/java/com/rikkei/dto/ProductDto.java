package com.rikkei.dto;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;


public class ProductDto{
	private Long productId;
	@NotEmpty
	@Length(min = 2)
	private String name;
	@NotNull
	@Min(value = 1)
	private int quantity;
	@NotNull
	@Min(value = 10000)
	private double unitPrice;
	private String image;
	@NotEmpty
	private String desciption;
	@NotNull
	@Min(value = 0)
	@Max(value = 100)
	private double discount;
	private Date enteredDate;
	private short status;
	private Long categoryId;
	private boolean isEdit = false;
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public Date getEnteredDate() {
		return enteredDate;
	}
	public void setEnteredDate(Date enteredDate) {
		this.enteredDate = enteredDate;
	}
	public short getStatus() {
		return status;
	}
	public void setStatus(short status) {
		this.status = status;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public boolean isEdit() {
		return isEdit;
	}
	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}
	public ProductDto(Long productId, @NotEmpty @Length(min = 2) String name, @NotNull @Min(1) int quantity,
			@NotNull @Min(10000) double unitPrice, String image, @NotEmpty String desciption,
			@NotNull @Min(0) @Max(100) double discount, Date enteredDate, short status, Long categoryId,
			boolean isEdit) {
		super();
		this.productId = productId;
		this.name = name;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.image = image;
		this.desciption = desciption;
		this.discount = discount;
		this.enteredDate = enteredDate;
		this.status = status;
		this.categoryId = categoryId;
		this.isEdit = isEdit;
	}
	public ProductDto() {
		super();
	}
	
	
}
