package com.example.fulbomatchmaking.business.account;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fulbomatchmaking.business.account.model.Account;
import com.example.fulbomatchmaking.business.account.model.AccountRequest;
import com.example.fulbomatchmaking.business.account.model.AccountTO;
import com.example.fulbomatchmaking.repositories.AccountRepository;
import com.example.utils.AES;

@Service
public class AccountService {
	
	@Autowired 
	private AccountRepository accountRepository;
	
	
	public AccountTO getCount(AccountRequest request) {
		String pass = AES.decryptText(request.getPass(), "fmm2023");
		Account de = accountRepository.findByUsAndPass(request.getUs(), pass);
		AccountTO account = AccountMapper.mapTo(de);
		account.setId(AES.encrypt(de.getId()+"", "fmm2023"));
		account.setPass(AES.encrypt(de.getPass()+"", "fmm2023"));
		return account;
	}
	


}
