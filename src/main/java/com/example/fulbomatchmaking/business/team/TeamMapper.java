package com.example.fulbomatchmaking.business.team;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.fulbomatchmaking.business.team.model.Team;
import com.example.fulbomatchmaking.business.team.model.TeamTO;

public class TeamMapper {


	public static TeamTO mapTo(Team de) {
		TeamTO to = new TeamTO();
		to.setId(de.getId());
		to.setName(de.getName());
		List<Long> users = new ArrayList<>();
		Arrays.asList(de.getAssociated_users().split(",")).stream().forEach(e->{
			if(e != null && e.trim() != "") {
				users.add(Integer.valueOf(e.trim()).longValue());
			}
		});
		to.setAssociatedUsers(users);
		List<Long> admins = new ArrayList<>();
		Arrays.asList(de.getAdmins().split(",")).stream().forEach(e->{
			if(e != null && e.trim() != "") {
				admins.add(Integer.valueOf(e.trim()).longValue());
			}
		});
		to.setAdmins(admins);
		return to;
	}

	public static Team mapDe(TeamTO to) {
		Team de = new Team();
		de.setId(to.getId());
		de.setName(to.getName());
		if(to.getAssociatedUsers() != null && !to.getAssociatedUsers().isEmpty()) {
			String str = to.getAssociatedUsers().toString().trim().replace(" ","").replace("]", "").replace("[", "");
			de.setAssociated_users(str);
		}
		if(to.getAdmins() != null && !to.getAdmins().isEmpty()) {
			String str2 = to.getAdmins().toString().trim().replace(" ","").replace("]", "").replace("[", "");
			de.setAdmins(str2);
		}
		return de;
	}


}
