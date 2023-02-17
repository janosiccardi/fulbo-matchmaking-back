package com.example.fulbomatchmaking.business.account;

import com.example.fulbomatchmaking.business.account.model.Account;
import com.example.fulbomatchmaking.business.account.model.AccountTO;

public class AccountMapper {

	public static AccountTO mapTo(Account de) {
		AccountTO to = new AccountTO();
		to.setNickname(de.getNickname());
		to.setUs(de.getUs());
		return to;
	}
	
	

}
