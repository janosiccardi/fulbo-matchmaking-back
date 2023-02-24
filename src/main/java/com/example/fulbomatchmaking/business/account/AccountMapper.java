package com.example.fulbomatchmaking.business.account;

import com.example.fulbomatchmaking.business.account.model.AccountDE;
import com.example.fulbomatchmaking.business.account.model.AccountTO;

public class AccountMapper {

	public static AccountTO mapTo(AccountDE de) {
		AccountTO to = new AccountTO();
		to.setNickname(de.getNickname());
		to.setUs(de.getUs());
		to.setSmpMode(de.getSmpMode());
		return to;
	}

	public static AccountDE mapDe(AccountTO to) {
		AccountDE de = new AccountDE();
		de.setNickname(to.getNickname());
		de.setUs(to.getUs());
		de.setSmpMode(to.getSmpMode());
		return de;
	}
	

}
