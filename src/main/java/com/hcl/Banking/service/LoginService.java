package com.hcl.Banking.service;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.Banking.entity.*;
import com.hcl.Banking.entity.Registration;
import com.hcl.Banking.exception.ResourceNotFoundException;
import com.hcl.Banking.repository.FundtransferRepository;
import com.hcl.Banking.repository.RegistrationRepository;

@Service
public class LoginService {

	@Autowired
    RegistrationRepository loginRepository;
	
	@Autowired
	FundtransferRepository fundtransferRepository;
	
	/**
	 * @param login user name and password
	 * @return the list of all the transactions happened
	 */
	public List<FundTranfer> validateLogin(@Valid Login login) {
			Registration userDetailsfromDB =  loginRepository.findById(login.getUserNumber()).orElseThrow(() -> new ResourceNotFoundException("Login", "id", login.getUserNumber()));
			if(login.getPassword().equals(userDetailsfromDB.getPassword())) {
				List<FundTranfer> fundTransferAllRecords= fundtransferRepository.findAll();
				for(FundTranfer record : fundTransferAllRecords) {
					if(!record.getUserId().equals(login.getUserNumber())) 
						fundTransferAllRecords.remove(record);
				}
				return fundTransferAllRecords;
			}
			return Collections.emptyList();
	}

}
