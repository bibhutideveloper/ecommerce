package com.project.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.ecommerce.model.Cart;
import com.project.ecommerce.model.Product;
import com.project.ecommerce.model.User;
import com.project.ecommerce.service.CartService;
import com.project.ecommerce.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CartController {

	@Autowired
	private CartService cartService;

	@Autowired
	private ProductService productService;

	@GetMapping("/cart")
	public String openCart(HttpSession session, Model model) {
		User user = (User) session.getAttribute("userLoginData");
		if (user != null) {
			List<Cart> cartData = cartService.cartByUser(user);
			model.addAttribute("cartData", cartData);
//			for (Cart cart : cartData)
//				System.out.println(cart);
			Double grandTotal = cartService.grandTotal(cartData);
			model.addAttribute("gTotal", grandTotal);
			return "cart";
		} else {
			return "redirect:/login";
		}
	}

	@PostMapping("/addToCart")
	public String addToCart(@RequestParam("productId") Integer productId, HttpSession session) {
		// typecasting (session to User) bz converting user session data to User class
		// to store all data

		User user = (User) session.getAttribute("userLoginData");
		if (user != null) {
//			System.out.println(user);

			Product product = productService.searchProductById(productId);
//			System.out.println(product);
			Cart cart = new Cart();
			cart.setProduct(product);
			cart.setUser(user);
			cart.setProductQuantity(1);
			List<Cart> cartData = cartService.cartByUser(user);

			if (!cartData.isEmpty()) {
				System.out.println("Product>com");
				for (Cart oldCart : cartData) {
					if (productId == oldCart.getProduct().getProductId()) {
						cart.setProductQuantity(oldCart.getProductQuantity() + 1);
						cart.setCartId(oldCart.getCartId());

					}

				}

			}
//			System.out.println(cart);
			cartService.addToCart(cart);
			return "redirect:/shop";

		} else {
			return "redirect:/login";
		}
	}

	@Transactional
	@PostMapping("/deleteCart")
	public String deleteCart(@RequestParam("productId") Integer productId, HttpSession session) {
		User user = (User) session.getAttribute("userLoginData");
		Product product = productService.searchProductById(productId);
		cartService.deleteCart(user, product);
		return "redirect:/cart";
	}

	@PostMapping("/updateQuantity")
	public String updateQuantity(@RequestParam("cartId") Integer cartId,
			@RequestParam("quantityButton") String quantityBtn) {
		Cart cart = cartService.getCartById(cartId);
		System.out.println(cartId);
		if (quantityBtn.equals("+")) {
			cartService.incrementQuantity(cart);
		}

		else if (quantityBtn.equals("-") && cart.getProductQuantity() > 1) {
			cartService.decrementQuantity(cart);
		}

		return "redirect:/cart";
	}
}
