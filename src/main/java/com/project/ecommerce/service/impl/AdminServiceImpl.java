package com.project.ecommerce.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.ecommerce.model.Admin;
import com.project.ecommerce.repository.AdminRepository;
import com.project.ecommerce.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public Admin getByEmail(String email) {
		return adminRepository.findByEmail(email) ;
	}

}
