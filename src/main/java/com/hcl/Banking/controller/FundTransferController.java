package com.hcl.Banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.Banking.entity.Account;
import com.hcl.Banking.entity.FundTranfer;
import com.hcl.Banking.service.FundTransferService;

/**
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/fundtransfer")
public class FundTransferController {

	@Autowired
	FundTransferService fundTransferService;
	
	/**
	 * @param id From Account user id
	 * @return List<Account> list of all the payees
	 */
	@GetMapping("/getAllPayees/{id}")
	public ResponseEntity<List<Account>> getAllPayees(@PathVariable Long id) {
		return new ResponseEntity<>(fundTransferService.getAllPayees(id),HttpStatus.OK);
	}
	
	
	/**
	 * @param fundTranferDetails Details of toAccount, FromAccount, Amount and User id
	 * @param id From Account user id
	 * @return FundTransfer Object
	 */
	@PutMapping("/update/{id}")
	public ResponseEntity<FundTranfer> fundTransfer(@RequestBody FundTranfer fundTranferDetails, @PathVariable Long id) {
		return new ResponseEntity<>(fundTransferService.transferringFunds(fundTranferDetails, id), HttpStatus.OK);
	}
	
}
