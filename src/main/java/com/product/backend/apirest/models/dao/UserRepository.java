package com.product.backend.apirest.models.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.backend.apirest.models.entity.User;

/**
 * User repository for CRUD operations.
 */
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
}
