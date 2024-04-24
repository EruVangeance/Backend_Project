package com.demo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);
}
