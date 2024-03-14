package com.example.fulbomatchmaking.business.account;


import java.util.Arrays;
import java.util.List;

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
		AccountTO to = AccountMapper.mapTo(de);
		to.setPass(AES.encrypt(de.getPass()+"", "fmm2023"));
		return to;
	}


	public AccountTO save(AccountTO account) {
		Account de = accountRepository.save(AccountMapper.mapDe(account));
		AccountTO to = AccountMapper.mapTo(de);
		to.setPass(AES.encrypt(de.getPass()+"", "fmm2023"));
		return to;
	}


	public void addUserToTeam(Integer user, Long team) throws Exception {
		Account exist = accountRepository.getById(user);
		if(exist != null) {
			exist.setTeams(exist.getTeams()+","+team);
			accountRepository.save(exist);
		}else {
			throw new Exception("This user doesn't exist!");
		}

	}


	public void deleteUserOfTeam(Integer user, Long team) throws Exception {
		Account exist = accountRepository.getById(user);
		if(exist != null) {
			List<Integer> groups = AccountMapper.mapTo(exist).getTeams();
			groups.removeAll(Arrays.asList(Integer.valueOf(team.intValue())));
			String grp = groups.toString().trim().replace(" ","").replace("]", "").replace("[", "");
			exist.setTeams(grp);
			accountRepository.save(exist);
		}else {
			throw new Exception("This user doesn't exist!");
		}

	}



}
