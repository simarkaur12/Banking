package com.hcl.Banking.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Account")
public class Account {
	
	@Id
	Long accountId;
	
	String accountName;
	
	//@Value("${some.key:10000}")
	Long openingBal;
	
	Long userId;
	
	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Long getOpeningBal() {
		return openingBal;
	}

	public void setOpeningBal(Long openingBal) {
		this.openingBal = openingBal;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
