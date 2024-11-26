package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.entity.User;
import com.user.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired UserRepo userRepo;
	
	
	public List<User> getBooks() {
		return this.userRepo.findAll();
	}
	
	public User getBookById(Long userId) {
		return this.userRepo.findById(userId).get();
	}
	
	public User createUser(User user) {
		return this.userRepo.save(user);
	}
	
	public User updateUser(User user) {
		return this.userRepo.save(user);
	}
	
	public void deleteUser(Long userId) {
		this.userRepo.deleteById(userId);
	}
}