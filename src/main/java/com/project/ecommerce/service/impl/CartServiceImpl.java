package com.project.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerce.model.Cart;
import com.project.ecommerce.model.Product;
import com.project.ecommerce.model.User;
import com.project.ecommerce.repository.CartRepository;
import com.project.ecommerce.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private CartRepository cartRepository;

	@Override
	public void addToCart(Cart cart) {
		
		cartRepository.save(cart);
		
	}

	@Override
	public List<Cart> cartByUser(User user) {
		
		return cartRepository.findByUser(user);
	}

	@Override
	public void deleteCart(User user, Product product) {
		cartRepository.deleteByUserAndProduct(user, product);
		
	}

	@Override
	public void incrementQuantity(Cart cart) {
		cart.setProductQuantity(cart.getProductQuantity()+1);
		cartRepository.save(cart);
	}

	@Override
	public void decrementQuantity(Cart cart) {
		cart.setProductQuantity(cart.getProductQuantity()-1);
		cartRepository.save(cart);
	}

	@Override
	public Cart getCartById(Integer cartId) {
		
		return cartRepository.getById(cartId);
	}

	@Override
	public Double grandTotal(List<Cart> cart) {
		Double grandTotal=0.0;
		for(Cart item:cart)
		{
			Double total=item.getProductQuantity() * item.getProduct().getProductPrice();
			grandTotal=grandTotal+total;
		}
		return grandTotal;
	}

	@Override
	public void clearCart(Cart cart) {
		cartRepository.delete(cart);
		
	}
}
