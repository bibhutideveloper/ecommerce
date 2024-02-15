package com.project.ecommerce.service;

import java.util.List;

import com.project.ecommerce.model.Product;

public interface ProductService {

	 void addProduct(Product product);//saving product
	 List<Product> getAllProducts();//List of All available product
	
	 void deleteProductById(Integer prodcutId);
	 Product searchProductById(Integer prodcutId);
	
	
}
