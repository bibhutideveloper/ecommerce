package com.project.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.ecommerce.model.Order;
import com.project.ecommerce.model.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
	List<Order> findOrderByUser(User user);
	
}
