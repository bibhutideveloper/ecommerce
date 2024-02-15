package com.project.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.ecommerce.model.User;
import com.project.ecommerce.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	private	UserService userService;
	
	@GetMapping("/signUp")
	public String  addUser()
	{
		return "signUp";
	}
	
	@PostMapping("/signUp")
	public String addUser(@ModelAttribute("user") User user)
	{
//		System.out.println(user);
		try {
			userService.addUser(user);
			return "redirect:/login";
		}
		catch (Exception e) {
			e.printStackTrace();
			return "redirect:/signUp";
		}
	}
	
	@GetMapping("/login")
	public String ViewloginPage()
	{
		return "login";
	}
	
	@PostMapping("/login")
	//public String login(@ModelAttribute("user")  User user) 
//	userService.findByUserEmail(userEmail);  or
	public String login(Model model, String userEmail ,String userPassword, HttpSession session)
	{
		try {
			User user = userService.findByUserEmail(userEmail);
			if(user!=null && userPassword.equals(user.getUserPassword()))
			{
				session.setAttribute("userLoginData", user);
				return "redirect:/";
			}
		} 
		catch (Exception e) {
			
			return "redirect:/login";
		}
	return "redirect:/login";
	}
	
	@GetMapping("/userLogout")
	public String logoutUser(HttpSession session)
	{
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/userDashboard")
	public String userDashboard(Model model, HttpSession session)
	{
		User user = (User) session.getAttribute("userLoginData");
		if(user!=null)
		{
			User userData=	userService.findByUserEmail(user.getUserEmail());
			model.addAttribute("userData" ,userData);
			return "userDashboard";
		}
		else
		{
			return "redirect:/login";
		}
		
	}
	
	@PostMapping("/userUpdate")
	public String userUpdate(@RequestParam("userEmail")String userEmail, Model model)
	{
		User user = userService.findByUserEmail(userEmail);
		model.addAttribute("userData", user);
		return "userUpdate";
		
		
	}
}
