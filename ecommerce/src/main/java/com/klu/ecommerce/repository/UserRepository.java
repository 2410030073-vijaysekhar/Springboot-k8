package com.klu.ecommerce.repository;

import com.klu.ecommerce.model.User;

import model.AppUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

	Object findByUsername(String username);

	void save(AppUser user);