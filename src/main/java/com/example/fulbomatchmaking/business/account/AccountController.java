package com.example.fulbomatchmaking.business.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fulbomatchmaking.business.account.model.Account;
import com.example.fulbomatchmaking.business.account.model.AccountRequest;


@CrossOrigin("*")
@RestController
@RequestMapping("account")
public class AccountController {

	@Autowired
	private AccountService service;
		
	
	@PostMapping("/get")
	public Account getAccount(@RequestBody AccountRequest request) {
		return service.getCount(request);
	}
	
}
