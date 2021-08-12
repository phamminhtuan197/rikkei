package com.rikkei.service;

import java.util.List;

import com.rikkei.entity.Product;

public interface IProductService {
	List<Product> getAll();
	
	void createProduct(Product product);
	
	void updateProduct(long id, Product product);
	
	void deleteProduct(long id);
	
	List<Product> getAllByCategory(long id);
	
	List<Product> findAllStatusTrue();
	
	boolean existsById(long id);
}
