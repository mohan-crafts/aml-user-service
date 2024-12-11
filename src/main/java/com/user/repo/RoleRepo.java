package com.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
	
}