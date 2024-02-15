package com.project.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerce.model.Product;
import com.project.ecommerce.repository.ProductRepository;
import com.project.ecommerce.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void addProduct(Product product) {
		
		 this.productRepository.save(product);
		
	}

	@Override
	public List<Product> getAllProducts() {
		
		return productRepository.findAll();
	}


	@Override
	public void deleteProductById(Integer prodcutId) {
		this.productRepository.deleteById(prodcutId);
		
	}

	@Override
	public Product searchProductById(Integer prodcutId) {
		
		return productRepository.getById(prodcutId);
	}

}
