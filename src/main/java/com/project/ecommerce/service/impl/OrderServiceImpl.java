package com.project.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerce.model.Order;
import com.project.ecommerce.model.User;
import com.project.ecommerce.repository.OrderRepository;
import com.project.ecommerce.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void placeOrder(Order order) {
		orderRepository.save(order);
		
	}

	@Override
	public List<Order> orderByUser(User user) {
		
		return orderRepository.findOrderByUser(user);
	}

	@Override
	public Order getByOrderId(Integer orderId) {
		
		return orderRepository.getById(orderId);
	}

}
