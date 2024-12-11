package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.Role;
import com.user.repo.RoleRepo;

@Service
public class RoleService {
	
	@Autowired RoleRepo roleRepo;
	
	
	public List<Role> getRoles() {
		return this.roleRepo.findAll();
	}
	
	public Role getRoleById(Long userId) {
		return this.roleRepo.findById(userId).get();
	}
	
	
}