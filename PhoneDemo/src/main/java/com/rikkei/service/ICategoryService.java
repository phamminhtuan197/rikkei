package com.rikkei.service;

import java.util.List;

import com.rikkei.entity.Category;

public interface ICategoryService {
	
	List<Category> getAllCategory();
	
	Category getCategory(long id);
	
	void createCategory(Category category);
	
	void updateCategory(long id, Category category);
	
	void deleteCategory(long id);
}
