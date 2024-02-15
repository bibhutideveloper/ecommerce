package com.project.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.ecommerce.model.Admin;
import com.project.ecommerce.service.AdminService;



@Controller
public class AdminController {
      
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/admin")
	//login page form
	public String viewAdminLogin(Model model)
	{
		model.addAttribute("admin",new Admin() );
		return "/admin/index";
	}
	
	@PostMapping("/admin")
	public String adminLogin(String email, String password, Model model) {
		 Admin admin = adminService.getByEmail(email);
//		System.out.println(admin);
		 if(admin!=null && password.equals(admin.getPassword()))
		 {
			 System.out.println("Login Success");
			 return "redirect:/adminDashboard";
			 
		 }
		 
		 else {
			System.out.println("something went wrong ");
			return "redirect:/admin";
		}
		 
		
	}
	@GetMapping("/adminDashboard")
	public String getDashboard()
	{
		return "admin/dashboard";
	}
	
	@GetMapping("/logout")
	public String adminLogout()
	{
		return "redirect:/admin";
	}
	
	
}