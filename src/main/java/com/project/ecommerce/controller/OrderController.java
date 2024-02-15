package com.project.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.ecommerce.model.Cart;
import com.project.ecommerce.model.Order;
import com.project.ecommerce.model.Product;
import com.project.ecommerce.model.User;
import com.project.ecommerce.service.CartService;
import com.project.ecommerce.service.OrderService;
import com.project.ecommerce.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
public class OrderController {

	@Autowired
	private CartService cartService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private ProductService productService;

	@GetMapping("/checkout")
	public String checkout(Model model, HttpSession session) {

		User user = (User) session.getAttribute("userLoginData");
		if (user != null) {
			List<Cart> cartData = cartService.cartByUser(user);
			model.addAttribute("cartData", cartData);
//			for (Cart cart : cartData)
//				System.out.println(cart);
			Double grandTotal = cartService.grandTotal(cartData);
			model.addAttribute("gTotal", grandTotal);
			return "checkout";
		} else {
			return "redirect:/login";
		}
	}

	@PostMapping("/checkout")
	public String placeOrder(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("address") String address, @RequestParam("phone") String phone, HttpSession session) {
		User user = (User) session.getAttribute("userLoginData");
		List<Cart> cartData = cartService.cartByUser(user);

		// insert Order Data one By one
		for (Cart cart : cartData) {
			Order order = new Order();
			order.setProductName(cart.getProduct().getProductName());
			order.setProductCategory(cart.getProduct().getProductCategory());
			order.setProductPrice(cart.getProduct().getProductPrice());
			order.setProductImage(cart.getProduct().getProductImage());
			order.setProductQuantity(cart.getProductQuantity());
			order.setOrderStatus("pending");
			order.setPaymentMode("cash");
			order.setUser(user);
			order.setOrderUserName(name);
			order.setOrderUserEmail(email);
			order.setOrderUserPhone(phone);
			order.setOrderAddress(address);
			order.setCancelDate(null);
//			System.out.println("OrderData: "+order);
			orderService.placeOrder(order);
		}
		// clear Cart Data after Order place
		for (Cart cart : cartData) {
			cartService.clearCart(cart);

		}
		// update product Stock After Order Placed
		for (Cart cart : cartData) {
			Product product = cart.getProduct();
			int orderedQuntity = cart.getProductQuantity();
			int updatedStock = product.getProductStock() - orderedQuntity;
			product.setProductStock(updatedStock);
			productService.addProduct(product);
		}

//		order.setProductName(order.getProductName())
		return "redirect:/orderConfirmPage";
	}

	@GetMapping("/orderConfirmPage")
	public String orderConfirm() {
		return "orderConfirmPage";

	}

	@GetMapping("/userOrders")
	public String userOrders(HttpSession session, Model model) {
		User user = (User) session.getAttribute("userLoginData");
		if (user != null) {
			List<Order> orderData = orderService.orderByUser(user);
			model.addAttribute("orderData", orderData);

		}
		return "userOrders";
	}

	@GetMapping("/userOrders/{orderId}")
	public String userOrders(@PathVariable("orderId") Integer orderId, HttpSession session, Model model) {
		User user = (User) session.getAttribute("userLoginData");

		if (user!=null) 
		{
		Order order=orderService.getByOrderId(orderId);
		model.addAttribute("order", order);
			return "singleOrder";
		}
		else 
		{
			return "redirect:/login";
		}
	}
}
