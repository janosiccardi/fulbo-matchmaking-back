package com.example.fulbomatchmaking.business.team;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fulbomatchmaking.business.account.AccountService;
import com.example.fulbomatchmaking.business.team.model.Team;
import com.example.fulbomatchmaking.business.team.model.TeamTO;
import com.example.fulbomatchmaking.repositories.TeamRepository;

@Service
public class TeamService {

	@Autowired
	@Qualifier("teamRepository")
	private TeamRepository teamRepository;

	@Autowired
	private AccountService accountService;


	
	public TeamTO save(TeamTO team) throws Exception {
		Team de = teamRepository.save(TeamMapper.mapDe(team));
		if(team.getAssociatedUsers() != null && team.getAssociatedUsers().size() == 1) {
			accountService.addUserToTeam(team.getAssociatedUsers().get(0), de.getId());
		}
		TeamTO to = TeamMapper.mapTo(de);
		return to;
	}


	
	public void delete(Long id) {
		Team de = teamRepository.getById(id);
		List<Integer> users = TeamMapper.mapTo(de).getAssociatedUsers();
		users.stream().forEach(u -> {
			try {
				accountService.deleteUserOfTeam(u, de.getId());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		teamRepository.deleteById(id);
	}


	public void addUser(Integer user, Long team) throws Exception {
		Team de = teamRepository.getById(team);
		accountService.addUserToTeam(user, team);
		de.setAssociated_users(de.getAssociated_users()+","+user);
		teamRepository.save(de);
	}


	public void deleteUser(Integer user, Long team) throws Exception {
		Team de = teamRepository.getById(team);
		accountService.deleteUserOfTeam(user, team);
		List<Integer> users = TeamMapper.mapTo(de).getAssociatedUsers();
		users.removeAll(Arrays.asList(user));
		String str = users.toString().trim().replace(" ","").replace("]", "").replace("[", "");
		de.setAssociated_users(str);
		teamRepository.save(de);
	}

}
