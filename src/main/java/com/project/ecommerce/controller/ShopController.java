package com.project.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.ecommerce.service.ProductService;

@Controller
public class ShopController {

	@Autowired
	private	ProductService productService;

	@GetMapping("/shop")
	public String viewShop(Model model)
	{
		
		model.addAttribute("products", productService.getAllProducts());
//		for (Product product1 : allProducts) {
//			System.out.println(product1);
//		}
		return "shop";
	}
}
