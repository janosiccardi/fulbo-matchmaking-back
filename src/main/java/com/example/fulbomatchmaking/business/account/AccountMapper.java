package com.example.fulbomatchmaking.business.account;

import com.example.fulbomatchmaking.business.account.model.Account;
import com.example.fulbomatchmaking.business.account.model.AccountTO;

public class AccountMapper {

	public static AccountTO mapTo(Account de) {
		AccountTO to = new AccountTO();
		to.setNickname(de.getNickname());
		to.setUs(de.getUs());
		to.setSmpMode(de.getSmpMode());
		return to;
	}

	public static Account mapDe(AccountTO to) {
		Account de = new Account();
		de.setNickname(to.getNickname());
		de.setUs(to.getUs());
		de.setSmpMode(to.getSmpMode());
		return de;
	}
	

}
