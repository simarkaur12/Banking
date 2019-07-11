package com.hcl.Banking.DTO;

/**
 * @author Administrator
 *
 */
public class LoginDTO {
	
	private Long userNumber;
	private String password;

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
