package com.rikkei.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;


public class CategoryDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long categoryId;
	@NotEmpty
	@Length(min = 3)
	private String name;
	
	private boolean isEdit = false;

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEdit() {
		return isEdit;
	}

	public void setEdit(boolean isEdit) {
		this.isEdit = isEdit;
	}

	public CategoryDto(Long categoryId, @NotEmpty @Length(min = 3) String name, boolean isEdit) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.isEdit = isEdit;
	}

	public CategoryDto() {
		super();
	}
	
	
}
