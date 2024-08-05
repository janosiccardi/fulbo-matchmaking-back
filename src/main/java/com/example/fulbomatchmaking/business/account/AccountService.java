package com.example.fulbomatchmaking.business.account;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fulbomatchmaking.business.account.model.Account;
import com.example.fulbomatchmaking.business.account.model.AccountRequest;
import com.example.fulbomatchmaking.business.account.model.AccountTO;
import com.example.fulbomatchmaking.business.team.TeamMapper;
import com.example.fulbomatchmaking.business.team.model.Team;
import com.example.fulbomatchmaking.business.team.model.TeamTO;
import com.example.fulbomatchmaking.repositories.AccountRepository;
import com.example.fulbomatchmaking.repositories.TeamRepository;
import com.example.utils.AES;

@Service
public class AccountService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TeamRepository teamRepository;


	public AccountTO getAccount(AccountRequest request) {
		String pass = AES.decryptText(request.getPass(), "fmm2023");
		Account de = accountRepository.findByUsAndPass(request.getUs(), pass);
		AccountTO to = AccountMapper.mapTo(de);
		List<Team> teams = this.teamRepository.findAllById(to.getGroups());
		List<TeamTO> teamTOs = new ArrayList<TeamTO>();
		teams.stream().forEach(team -> {
			TeamTO teamTO = TeamMapper.mapTo(team);
			teamTO.setUsers(AccountMapper.mapToList(accountRepository.findAllById(teamTO.getAssociatedUsers())));
			teamTOs.add(teamTO);
		});
		to.setTeams(teamTOs);
		to.setPass(AES.encrypt(de.getPass()+"", "fmm2023"));
		return to;
	}
	


	public AccountTO save(AccountTO account) {
		String pass = AES.decryptText(account.getPass(), "fmm2023");
		Account de = AccountMapper.mapDe(account);
		de.setPass(pass);
		de = accountRepository.save(de);
		AccountTO to = AccountMapper.mapTo(de);
		to.setPass(AES.encrypt(de.getPass()+"", "fmm2023"));
		return to;
	}


	public AccountTO addUserToTeam(Long user, Long team,String name) throws Exception {
		Account exist = accountRepository.getById(user);
		if(exist != null && exist.getNickname().equals(name)) {
			if(exist.getTeams().length() > 0) {
				exist.setTeams(exist.getTeams()+","+team);			
			}else{
				exist.setTeams(team.toString());			
			}
			accountRepository.save(exist);
			return  AccountMapper.mapTo(exist);
		}else {
			throw new Exception("El usuario no existe o el nombre es incorrecto!");
		}

	}
	public void addFirstUserToTeam(Long user, Long team) throws Exception {
		Account exist = accountRepository.getById(user);
		if(exist.getTeams() != null && exist.getTeams().length() > 0) {
			exist.setTeams(exist.getTeams()+","+team);			
		}else{
			exist.setTeams(team.toString());			
		}
		accountRepository.save(exist);

	}

	public void deleteUserOfTeam(Long user, Long team) throws Exception {
		Account exist = accountRepository.getById(user);
		if(exist != null) {
			List<Long> groups = AccountMapper.mapTo(exist).getGroups();
			groups.removeAll(Arrays.asList(Integer.valueOf(team.intValue()).longValue()));
			String grp = groups.toString().trim().replace(" ","").replace("]", "").replace("[", "");
			exist.setTeams(grp);
			accountRepository.save(exist);
		}else {
			throw new Exception("El usuario no existe!");
		}

	}



}
