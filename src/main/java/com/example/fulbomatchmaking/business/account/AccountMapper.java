package com.example.fulbomatchmaking.business.account;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.fulbomatchmaking.business.account.model.Account;
import com.example.fulbomatchmaking.business.account.model.AccountTO;
import com.example.fulbomatchmaking.business.team.TeamMapper;
import com.example.fulbomatchmaking.business.team.model.Team;
import com.example.fulbomatchmaking.business.team.model.TeamTO;

public class AccountMapper {

	public static List<AccountTO> mapToList(List<Account> des) {
		return des.stream().map(AccountMapper::mapTo).toList();
	}

	public static AccountTO mapTo(Account de) {
		AccountTO to = new AccountTO();
		to.setId(de.getId());
		to.setNickname(de.getNickname());
		to.setUs(de.getUs());
		to.setPass(de.getPass());
		List<Long> groups = new ArrayList<>();
		if(de.getTeams() != null) {
			Arrays.asList(de.getTeams().split(",")).stream().forEach(e->{
				if(e != null && e.trim().length() > 0) {
					groups.add(Integer.valueOf(e.trim()).longValue());
				}
			});
			}
		to.setGroups(groups);
		to.setSmpMode(de.getSmpMode());
		return to;
	}

	public static Account mapDe(AccountTO to) {
		Account de = new Account();
		de.setNickname(to.getNickname());
		de.setUs(to.getUs());
		de.setPass(to.getPass());
		de.setSmpMode(to.getSmpMode());
		return de;
	}


}
