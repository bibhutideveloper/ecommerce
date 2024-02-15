package com.project.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ecommerce.model.Cart;
import com.project.ecommerce.model.Product;
import com.project.ecommerce.model.User;
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
		
	List<Cart> findByUser(User user);
	void deleteByUserAndProduct(User user, Product product);
}
