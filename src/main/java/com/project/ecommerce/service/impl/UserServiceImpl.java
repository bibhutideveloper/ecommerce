package com.project.ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerce.model.User;
import com.project.ecommerce.repository.UserRepository;
import com.project.ecommerce.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void addUser(User user) {
		this.userRepository.save(user);
		
	}

	@Override
	public User findByUserEmail(String userEmail) {
		System.out.println(userRepository.findByUserEmail(userEmail));
		return userRepository.findByUserEmail(userEmail);
	}

	
}
