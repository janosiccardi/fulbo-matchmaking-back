package com.example.fulbomatchmaking.business.player;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.fulbomatchmaking.business.player.model.DeletePlayerRequest;
import com.example.fulbomatchmaking.business.player.model.Player;
import com.example.fulbomatchmaking.business.player.model.PlayerDE;

@CrossOrigin("*")
@RestController
@RequestMapping("player")
public class PlayerController {

	@Autowired
	private PlayerService service;
	
	
	@GetMapping("/getPlayers")
	public List<Player> getPlayers(@RequestParam(value = "id") String id) {
		return service.getPlayers(id);
	}
	
	@PostMapping("/deletePlayer")
	public void deletePlayer(@RequestBody DeletePlayerRequest request) {
		service.deletePlayer(request);
	}
	
	@PostMapping("/addPlayer")
	public ResponseEntity<?> addPlayer(@RequestBody Player player) {
		try {
			service.addPlayer(player);
			return ResponseEntity.ok("Player added");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	
	@PostMapping("/updatePlayer")
	public void updatePlayer(@RequestBody Player player) {
		service.updatePlayer(player);
	}
}
