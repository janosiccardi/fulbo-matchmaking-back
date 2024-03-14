package com.example.fulbomatchmaking.business.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fulbomatchmaking.business.team.model.TeamTO;


@CrossOrigin("*")
@RestController
@RequestMapping("team")
public class TeamController {

	@Autowired
	private TeamService service;

	@PostMapping("/save")
	public TeamTO save(@RequestBody TeamTO team) throws Exception {
		return service.save(team);
	}

	@PostMapping("delete")
	public void delete(@RequestParam(value = "id") Long id) {
		service.delete(id);
	}

	@PostMapping("/addUser")
	public void addUser(@RequestParam(value = "user") Integer user,
			@RequestParam(value = "team") Long team) throws Exception {
		service.addUser(user,team);
	}

	@PostMapping("/deleteUser")
	public void deleteUser(@RequestParam(value = "user") Integer user,
			@RequestParam(value = "team") Long team) throws Exception {
		service.deleteUser(user,team);
	}

}
