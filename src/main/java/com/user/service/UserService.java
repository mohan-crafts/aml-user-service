package com.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.dto.AccountCreationReq;
import com.user.entity.User;
import com.user.repo.AddressRepo;
import com.user.repo.RoleRepo;
import com.user.repo.UserRepo;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	@Autowired UserRepo userRepo;
	@Autowired RoleRepo roleRepo;
	@Autowired AddressRepo addressRepo;
	@Autowired private PasswordEncoder passwordEncoder;
	@Autowired private RestTemplate restTemplate;
	
	public List<User> getBooks() {
		
//		Given a string, implement a isBalanced function
//		"{{}{}{}}" -> balanced
//		“{}{}” -> balanced
//		“{{}{}}{}” -> balanced
//		"{{}{}" -> not balanced
//		"{{}}{" -> not balanced
//		"}{}{}" -> not balanced
//		“{}}{{}” -> not balanced
		
		
		
		
		return this.userRepo.findAll();
	}
	
	
	
		
	
	public User getBookById(Long userId) {
		return this.userRepo.findById(userId).get();
	}
	
	@Transactional
	public User createUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Long existingAddressId  = user.getAddress().getId();
		Long existingRoleId = user.getRole().getId();
		user.setAddress(this.addressRepo.findById(existingAddressId).get());
		user.setRole(this.roleRepo.findById(existingRoleId).get());
		User createdUser = this.userRepo.save(user);

		AccountCreationReq accountCreationReq = new AccountCreationReq(createdUser.getId());

        // Headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        // HttpEntity
        HttpEntity<AccountCreationReq> requestEntity = new HttpEntity<>(accountCreationReq, headers);

        // POST Request
        ResponseEntity<String> response = restTemplate.postForEntity("http://ACCOUNTS-APP/accounts", requestEntity, String.class);
        
		
		return createdUser;
	}
	
	public User updateUser(User user) {
		return this.userRepo.save(user);
	}
	
	public void deleteUser(Long userId) {
		this.userRepo.deleteById(userId);
	}
}