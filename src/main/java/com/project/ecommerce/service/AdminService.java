package com.project.ecommerce.service;

import com.project.ecommerce.model.Admin;

public interface AdminService {
  Admin getByEmail(String email);
 
}
