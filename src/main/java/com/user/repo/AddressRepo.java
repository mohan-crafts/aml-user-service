package com.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.Address;

public interface AddressRepo extends JpaRepository<Address, Long> {
	
}