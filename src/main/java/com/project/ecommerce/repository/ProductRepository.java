package com.project.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.ecommerce.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
