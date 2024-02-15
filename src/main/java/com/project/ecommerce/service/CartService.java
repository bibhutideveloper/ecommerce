package com.project.ecommerce.service;

import java.util.List;

import com.project.ecommerce.model.Cart;
import com.project.ecommerce.model.Product;
import com.project.ecommerce.model.User;

public interface CartService {

	void addToCart(Cart cart);
	List<Cart> cartByUser(User user);
	void deleteCart(User user, Product product);
	void incrementQuantity(Cart cart);
	void decrementQuantity(Cart cart);
	Cart getCartById(Integer cartId);
	Double grandTotal(List<Cart> cart);
	void clearCart(Cart cart);
}
