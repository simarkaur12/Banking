package com.hcl.Banking.service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.Banking.entity.Account;
import com.hcl.Banking.entity.FundTranfer;
import com.hcl.Banking.exception.ResourceNotFoundException;
import com.hcl.Banking.repository.AccountRepository;
import com.hcl.Banking.repository.FundtransferRepository;

@Service
public class FundTransferService {

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	FundtransferRepository fundTransferRepository;
	
	/**
	 * @param id User name of the current loginned user
	 * @return List<Account> list of all the payees
	 */
	public List<Account> getAllPayees(Long id) {
		List<Account> allAccounts = accountRepository.findAll();
		for(int i=0; i<allAccounts.size(); i++) {
			if(allAccounts.get(i).getUserId().equals(id)) {
				allAccounts.remove(i);
			}
		}
		return allAccounts;
		
	}

	
	/**
	 * @param fundTranferDetails, fund transfer details, from account, to account, amount
	 * @param id id of the user
	 * @return Fundtransfer object having all the fund transfer details
	 */
	public FundTranfer transferringFunds(FundTranfer fundTranferDetails, Long id) {
		Account account = accountRepository.findByUserId(id);
				
		if(null==account)
			throw new ResourceNotFoundException("Fundtransfer", "id", id);

		fundTranferDetails.setUserId(id);
		fundTranferDetails.setFromAccount(account.getAccountId());
		account.setOpeningBal(account.getOpeningBal()+fundTranferDetails.getAmount());
		
		FundTranfer fundTranfer = new FundTranfer();
		fundTranfer.setAmount(fundTranferDetails.getAmount());
		fundTranfer.setUserId(id);
		fundTranfer.setFromAccount(account.getAccountId());
		fundTranfer.setToAccount(fundTranferDetails.getToAccount());
		fundTranfer.setTransactionDate(new Date(Calendar.getInstance().getTime().getTime()));
		
		return fundTransferRepository.save(fundTranfer);	
	}
}
