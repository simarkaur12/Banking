package com.hcl.Banking.DTO;

public class FundTransferDetailsDTO {

	Long userNumber;
	Long payeeAccountNumber;
	Long amount;
	public Long getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(Long userNumber) {
		this.userNumber = userNumber;
	}
	public Long getPayeeAccountNumber() {
		return payeeAccountNumber;
	}
	public void setPayeeAccountNumber(Long payeeAccountNumber) {
		this.payeeAccountNumber = payeeAccountNumber;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	
	
}
