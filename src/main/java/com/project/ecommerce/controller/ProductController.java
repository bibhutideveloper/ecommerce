package com.project.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.ecommerce.model.Product;
import com.project.ecommerce.service.ProductService;





@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/viewProduct")
	public String viewProductDetails(Model model)
	{
		model.addAttribute("products", productService.getAllProducts());
//		for (Product product1 : allProducts) {
//			System.out.println(product1);
//		}
		return "admin/viewProduct";
		
	}

	@GetMapping("/addProduct")
	public String addProduct() {

		return "admin/addProduct";
	}

	@PostMapping("/addProduct")
	public String addProduct(@ModelAttribute("productData") Product product) {
		try {
//    		System.out.println("Ajay");
//        	System.out.println(product);

			productService.addProduct(product);
			return "redirect:/viewProduct?success";
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/addProduct?error";
		}
	}
	
	@GetMapping("/updateProduct/{productId}")
	public String updateProductById(@PathVariable("productId")Integer productId, Model model)
	{ 
		
		Product product= productService.searchProductById(productId);
		model.addAttribute("productData",product);
		return "admin/updateProduct";
	}
	
	@GetMapping("/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId") Integer productId)
	{
		productService.deleteProductById(productId);
		return "redirect:/viewProduct?deleted";
	}
	
	@GetMapping("/singleProduct/{productId}")
	public String singleProduct(@PathVariable("productId") Integer productId, Model model)
	{
		Product product=productService.searchProductById(productId);
		model.addAttribute("product",product);
		
		return "singleProduct";
		
	}
}
