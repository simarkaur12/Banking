package com.hcl.Banking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.Banking.entity.Account;
import com.hcl.Banking.entity.Registration;
import com.hcl.Banking.service.RegistrationService;

@RestController
@RequestMapping("/registration")
public class RegisterController {

	@Autowired
	RegistrationService registrationService;
	
	/**
	 * @param registrationDetails get all the registration details 
	 * @return Account with registered entity
	 */
	@PostMapping("/register")
	public ResponseEntity<Account> registration(@Valid @RequestBody Registration registrationDetails){
		Account account = registrationService.registration(registrationDetails);
		return new ResponseEntity<>(account, HttpStatus.OK);
	}
}
