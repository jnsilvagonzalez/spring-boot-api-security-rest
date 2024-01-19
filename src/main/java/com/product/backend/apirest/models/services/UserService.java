package com.product.backend.apirest.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.backend.apirest.models.dao.UserRepository;
import com.product.backend.apirest.models.entity.User;
import com.product.backend.apirest.security.SpringSecurityConfig;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;

	@Autowired
	SpringSecurityConfig securityConfig;

	public void save(User user) {
		user.setPassword(securityConfig.passwordEncoder().encode(user.getPassword()));
		repo.save(user);
	}

}
