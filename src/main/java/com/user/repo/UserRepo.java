package com.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
	
}