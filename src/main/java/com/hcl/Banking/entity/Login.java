package com.hcl.Banking.entity;

/**
 * @author Administrator
 *
 */
public class Login {
	
	private Long userNumber;
	private String password;

	public Login() {
		
	}
	
	public Login(Long userNumber, String password) {
		this.userNumber=userNumber;
		this.password=password;
	}


	public Long getUserNumber() {
		return userNumber;
	}


	public void setUsername(Long userNumber) {
		this.userNumber = userNumber;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
}
