/**
 * 
 */
package com.hcl.Banking.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.Banking.entity.TransactionHistory;
import com.hcl.Banking.DTO.LoginDTO;
import com.hcl.Banking.exception.ResourceNotFoundException;
import com.hcl.Banking.service.LoginService;

/**
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
    LoginService loginService;
	
	//Validate login user
	/**
	 * @param login get user name and password from the user
	 * @return list of transactions happened
	 * @throws ResourceNotFoundException
	 */
	@PostMapping("/login")
	public ResponseEntity<List<TransactionHistory>> validateLogin(@Valid @RequestBody LoginDTO login) {
		return new ResponseEntity<>(loginService.validateLogin(login), HttpStatus.OK);
	}
	
}
