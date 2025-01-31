package com.user.dto;

import java.util.Date;

public class AccountCreationReq {

	private Long userId;
	
	private Long balance;
	
	private String status;
	
	private Date createdOn;
	
	private Date updatedOn;

	
	public AccountCreationReq(Long userId) {
		
		this.userId = userId;
		this.balance = Long.valueOf(0);
		this.status = "Active";
		this.createdOn = new Date();
		this.updatedOn = new Date();
	}
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
}
