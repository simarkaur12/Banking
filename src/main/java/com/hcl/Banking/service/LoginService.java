package com.hcl.Banking.service;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.Banking.DTO.LoginDTO;
import com.hcl.Banking.entity.*;
import com.hcl.Banking.entity.Registration;
import com.hcl.Banking.exception.ResourceNotFoundException;
import com.hcl.Banking.repository.TransactionHistoryRepository;
import com.hcl.Banking.repository.RegistrationRepository;

@Service
public class LoginService {

	@Autowired
    RegistrationRepository loginRepository;
	
	@Autowired
	TransactionHistoryRepository fundtransferRepository;
	
	/**
	 * @param login user name and password
	 * @return the list of all the transactions happened
	 */
	public List<TransactionHistory> validateLogin(@Valid LoginDTO login) {
			Registration userDetailsfromDB =  loginRepository.findById(login.getUserNumber()).orElseThrow(() -> new ResourceNotFoundException("Login", "id", login.getUserNumber()));
			if(login.getPassword().equals(userDetailsfromDB.getPassword())) {
				List<TransactionHistory> fundTransferAllRecords= fundtransferRepository.findAll();
				for(TransactionHistory record : fundTransferAllRecords) {
					if(!record.getUserNumber().equals(login.getUserNumber())) 
						fundTransferAllRecords.remove(record);
				}
				return fundTransferAllRecords;
			}
			return Collections.emptyList();
	}

}
