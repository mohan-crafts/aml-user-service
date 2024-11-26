package com.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired UserService userService;
	
	@GetMapping("") 
	public ResponseEntity<List<User>> getUsers() {
		return ResponseEntity.ok(this.userService.getBooks());
	}
	
	@GetMapping("/{id}") 
	public ResponseEntity<User> getUser(@PathVariable("id") Long userID) {
		return ResponseEntity.ok(this.userService.getBookById(userID));
	}
	
	@PostMapping("")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		return ResponseEntity.ok(this.userService.createUser(user));
	}
	
	@PutMapping("")
	public ResponseEntity<User> updateUser(@RequestBody User user) {
		return ResponseEntity.ok(this.userService.updateUser(user));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long userId) {
		this.userService.deleteUser(userId);
		return ResponseEntity.ok(true);
	}
}