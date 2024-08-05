package com.example.fulbomatchmaking.business.team;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fulbomatchmaking.business.account.model.Account;
import com.example.fulbomatchmaking.business.account.model.AccountTO;
import com.example.fulbomatchmaking.business.team.model.TeamTO;


@CrossOrigin("*")
@RestController
@RequestMapping("team")
public class TeamController {

	@Autowired
	private TeamService service;


	@GetMapping("/getTeams")
	public List<TeamTO> getTeams(@RequestParam(value = "ids") List<Long> ids) throws Exception {
		return service.getTeams(ids);
	}

	
	@PostMapping("/save")
	public TeamTO save(@RequestBody TeamTO team) throws Exception {
		return service.save(team);
	}

	@PostMapping("delete")
	public void delete(@RequestParam(value = "id") Long id) {
		service.delete(id);
	}

	@PostMapping("/addUser")
	public AccountTO addUser(@RequestParam(value = "user") Long user,
			@RequestParam(value = "team") Long team,
			@RequestParam(value = "name") String name) throws Exception {
		return service.addUser(user,team,name);
	}

	@PostMapping("/deleteUser")
	public void deleteUser(@RequestParam(value = "user") Long user,
			@RequestParam(value = "team") Long team) throws Exception {
		service.deleteUser(user,team);
	}

}
