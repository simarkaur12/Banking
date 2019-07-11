package com.hcl.Banking.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.Banking.entity.Account;
import com.hcl.Banking.entity.Registration;
import com.hcl.Banking.repository.AccountRepository;
import com.hcl.Banking.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	RegistrationRepository registrationRepository;
	
	@Autowired
	AccountRepository accountRepository;
	
	/**
	 * @param registrationDetails save all the registration details
	 * @return return the newly created account details
	 */
	public Account registration(@Valid Registration registrationDetails) {
			Registration registeredDetails = registrationRepository.save(registrationDetails);
			Account account = new Account();
			account.setAccountNumber(Math.round(Math.random()*1000000000));
			account.setAccountName(registeredDetails.getEmail());
			account.setOpeningBal(10000L);
			account.setUserNumber(registeredDetails.getUserNumber());
			return accountRepository.save(account);
	}
}
