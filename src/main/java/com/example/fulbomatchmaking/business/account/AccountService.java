package com.example.fulbomatchmaking.business.account;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fulbomatchmaking.business.account.model.Account;
import com.example.fulbomatchmaking.business.account.model.AccountRequest;
import com.example.fulbomatchmaking.repositories.AccountRepository;

@Service
public class AccountService {
	
	@Autowired 
	private AccountRepository accountRepository;
	
	
	public Account getCount(AccountRequest request) {
		return accountRepository.findByUsAndPass(request.getUs(), request.getPass());
	}
	


}
