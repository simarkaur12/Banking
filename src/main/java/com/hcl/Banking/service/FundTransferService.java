package com.hcl.Banking.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.Banking.DTO.FundTransferDetailsDTO;
import com.hcl.Banking.entity.Account;
import com.hcl.Banking.entity.TransactionHistory;
import com.hcl.Banking.repository.AccountRepository;
import com.hcl.Banking.repository.TransactionHistoryRepository;

@Service
public class FundTransferService {

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	TransactionHistoryRepository fundTransferRepository;
	
	/**
	 * @param id User name of the current loginned user
	 * @return List<Account> list of all the payees
	 */
	public List<Account> getAllPayees(Long id) {
		List<Account> allAccounts = accountRepository.findAll();
		for(int i=0; i<allAccounts.size(); i++) {
			if(allAccounts.get(i).getUserNumber().equals(id)) {
				allAccounts.remove(i);
			}
		}
		return allAccounts;
		
	}

	
	/**
	 * @param fundTranferDetails, fund transfer details, from account, to account, amount
	 * @return Fund Transfer object having all the fund transfer details
	 */
	public String transferringFunds(FundTransferDetailsDTO fundTranferDetails) {
		Account payerAccount = accountRepository.findByUserNumber(fundTranferDetails.getUserNumber());
		Account payeeAccount = accountRepository.findByAccountNumber(fundTranferDetails.getPayeeAccountNumber());
		
		payeeAccount.setOpeningBal(payeeAccount.getOpeningBal()+fundTranferDetails.getAmount());
		payerAccount.setOpeningBal(payerAccount.getOpeningBal()-fundTranferDetails.getAmount());
		
		accountRepository.save(payeeAccount);
		accountRepository.save(payerAccount);
		
		TransactionHistory payeeTransactionHistory = new TransactionHistory();
		payeeTransactionHistory.setAccountNumber(payeeAccount.getAccountNumber());
		payeeTransactionHistory.setAmount(fundTranferDetails.getAmount());
		payeeTransactionHistory.setBalance(payeeAccount.getOpeningBal());
		payeeTransactionHistory.setTransactionDate(LocalDateTime.now());
		payeeTransactionHistory.setType("DEBIT");
		payeeTransactionHistory.setUserNumber(payeeAccount.getUserNumber());
		
		fundTransferRepository.save(payeeTransactionHistory);
		
		TransactionHistory payerTransactionHistory = new TransactionHistory();
		payeeTransactionHistory.setAccountNumber(payerAccount.getAccountNumber());
		payeeTransactionHistory.setAmount(fundTranferDetails.getAmount());
		payeeTransactionHistory.setBalance(payerAccount.getOpeningBal());
		payeeTransactionHistory.setTransactionDate(LocalDateTime.now());
		payeeTransactionHistory.setType("CREDIT");
		payeeTransactionHistory.setUserNumber(payerAccount.getUserNumber());
		
		fundTransferRepository.save(payerTransactionHistory);
		
		return "Funds are transferred successfully";	
	}
}
