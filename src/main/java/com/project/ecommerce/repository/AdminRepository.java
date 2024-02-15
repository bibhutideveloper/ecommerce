package com.project.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.project.ecommerce.model.Admin;



public interface AdminRepository extends JpaRepository<Admin, Integer>{

	Admin  findByEmail(String email);
}
