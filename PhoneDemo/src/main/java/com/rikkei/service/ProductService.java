package com.rikkei.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rikkei.entity.Product;
import com.rikkei.repository.IProductRepository;

@Service
public class ProductService implements IProductService{

	@Autowired
	IProductRepository	productRepository;
	
	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return productRepository.findAllStatusTrue();
	}

	@Override
	public void createProduct(Product product) {
		// TODO Auto-generated method stub
		product.set
	}

	@Override
	public void updateProduct(long id, Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> getAllByCategory(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAllStatusTrue() {
		// TODO Auto-generated method stub
		return productRepository.findAllStatusTrue();
	}

	@Override
	public boolean existsById(long id) {
		// TODO Auto-generated method stub
		return productRepository.existsById(id);
	}

}
