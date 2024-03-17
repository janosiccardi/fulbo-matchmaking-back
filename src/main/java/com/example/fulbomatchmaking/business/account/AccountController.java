package com.example.fulbomatchmaking.business.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.fulbomatchmaking.business.account.model.AccountRequest;
import com.example.fulbomatchmaking.business.account.model.AccountTO;


@CrossOrigin("*")
@RestController
@RequestMapping("account")
public class AccountController {

	@Autowired
	private AccountService service;


	@PostMapping("/get")
	public AccountTO getAccount(@RequestBody AccountRequest request) {
		return service.getAccount(request);
	}


	@PostMapping("/save")
	public AccountTO save(@RequestBody AccountTO account) {
		return service.save(account);
	}

}
