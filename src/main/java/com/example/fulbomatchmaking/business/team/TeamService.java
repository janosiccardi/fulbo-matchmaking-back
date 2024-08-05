package com.example.fulbomatchmaking.business.team;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fulbomatchmaking.business.account.AccountMapper;
import com.example.fulbomatchmaking.business.account.AccountService;
import com.example.fulbomatchmaking.business.account.model.Account;
import com.example.fulbomatchmaking.business.account.model.AccountTO;
import com.example.fulbomatchmaking.business.team.model.Team;
import com.example.fulbomatchmaking.business.team.model.TeamTO;
import com.example.fulbomatchmaking.repositories.AccountRepository;
import com.example.fulbomatchmaking.repositories.TeamRepository;

@Service
public class TeamService {

	@Autowired
	@Qualifier("teamRepository")
	private TeamRepository teamRepository;

	@Autowired
	private AccountService accountService;
	@Autowired
	private AccountRepository accountRepository;


	
	public TeamTO save(TeamTO team) throws Exception {
		Team de = teamRepository.save(TeamMapper.mapDe(team));
		if(team.getAssociatedUsers() != null && team.getAssociatedUsers().size() == 1) {
			accountService.addFirstUserToTeam(team.getAssociatedUsers().get(0), de.getId());
		}
		TeamTO to = TeamMapper.mapTo(de);
		to.setUsers(AccountMapper.mapToList(accountRepository.findAllById(to.getAssociatedUsers())));
		return to;
	}


	
	public void delete(Long id) {
		Team de = teamRepository.getById(id);
		List<Long> users = TeamMapper.mapTo(de).getAssociatedUsers();
		users.stream().forEach(u -> {
			try {
				accountService.deleteUserOfTeam(u, de.getId());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		teamRepository.deleteById(id);
	}


	public AccountTO addUser(Long user, Long team,String name) throws Exception {
		Team de = teamRepository.getById(team);
		AccountTO ret = accountService.addUserToTeam(user, team,name);
		if(de.getAssociated_users().length() > 0) {
			de.setAssociated_users(de.getAssociated_users()+","+user);
		}else {
			de.setAssociated_users(user.toString());
		}
		teamRepository.save(de);
		return ret;
	}


	public void deleteUser(Long user, Long team) throws Exception {
		Team de = teamRepository.getById(team);
		accountService.deleteUserOfTeam(user, team);
		TeamTO to = TeamMapper.mapTo(de);
		List<Long> users = to.getAssociatedUsers();
		List<Long> admins = to.getAdmins();
		users.removeAll(Arrays.asList(user));
		admins.removeAll(Arrays.asList(user));
		String userStr = users.toString().trim().replace(" ","").replace("]", "").replace("[", "");
		String adminStr = admins.toString().trim().replace(" ","").replace("]", "").replace("[", "");
		de.setAssociated_users(userStr);
		de.setAdmins(adminStr);
		teamRepository.save(de);
	}



	public List<TeamTO> getTeams(List<Long> ids) {
		 List<TeamTO> ret = new ArrayList<TeamTO>();
		 ids.stream().forEach(id -> {
				Team de = teamRepository.getById(id);
				ret.add(TeamMapper.mapTo(de));
		 });
		return ret;
	}

}
