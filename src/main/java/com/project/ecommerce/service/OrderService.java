package com.project.ecommerce.service;

import java.util.List;

import com.project.ecommerce.model.Order;
import com.project.ecommerce.model.User;

public interface OrderService {

	void placeOrder(Order order);
	List<Order> orderByUser(User user);
	Order getByOrderId(Integer orderId);
}
