package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.Role;
import com.user.service.RoleService;

@RestController
@RequestMapping("/roles")
public class RoleController {
	
	@Autowired RoleService roleService;
	
	@GetMapping("") 
	public ResponseEntity<List<Role>> getRoles() {
		return ResponseEntity.ok(this.roleService.getRoles());
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<Role> getRole(@PathVariable("id") Long userID) {
		return ResponseEntity.ok(this.roleService.getRoleById(userID));
	}
	
	
}