package com.rikkei.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "products")
public class Product implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;
	private String name;
	private int quantity;
	private Double price;
	private Double discount;
//	@Column(columnDefinition = "LONGBLOB")
	private String image;
	private String description;
	private Date enteredDate;
	private Boolean status;
	
//	@OneToMany(mappedBy = "product")
//	private List<Rate> rates;	
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	private Category category;

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getEnteredDate() {
		return enteredDate;
	}

	public void setEnteredDate(Date enteredDate) {
		this.enteredDate = enteredDate;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product(Long productId, String name, int quantity, Double price, Double discount, String image,
			String description, Date enteredDate, Boolean status, Category category) {
		super();
		this.productId = productId;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.discount = discount;
		this.image = image;
		this.description = description;
		this.enteredDate = enteredDate;
		this.status = status;
		this.category = category;
	}

	public Product() {
		super();
	}
	
	
}
