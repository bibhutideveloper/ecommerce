package com.project.ecommerce.service;

import com.project.ecommerce.model.User;

public interface UserService {

	void addUser(User user);//saving User
	User findByUserEmail(String userEmail);//user type return bz   we will get data in form of User object
}
