package com.example.fulbomatchmaking.business.player;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.fulbomatchmaking.business.player.model.DeletePlayerRequest;
import com.example.fulbomatchmaking.business.player.model.Player;
import com.example.fulbomatchmaking.business.player.model.PlayerDE;
import com.example.fulbomatchmaking.repositories.PlayerRepository;



@Transactional
@Service
public class PlayerService {

	@Autowired
	@Qualifier("playerRepository")
	private PlayerRepository playerRepository;

	public List<Player> getPlayers(Integer id) {
		List<PlayerDE> des = playerRepository.findByTeam(id);
		PlayerDE overall = 	playerRepository.findByNameAndTeam("#Overall", 1);
		return PlayerMapper.mapTOList(des, overall);
	}
	@Transactional
	public void deletePlayer(DeletePlayerRequest request) {
		playerRepository.deleteByNameAndTeam(request.getPlayerName(), request.getTeam());
	}
	@Transactional
	public void addPlayer(Player player) throws Exception{
		PlayerDE exist = playerRepository.findByNameAndTeam(player.getName(), player.getTeam());
		if(exist == null) {
			PlayerDE playerToSave = PlayerMapper.mapDE(player);
		   playerRepository.save(playerToSave);
		}else {
			throw new Exception("This player already exist!");
		}
	}


	@Transactional
	public void updatePlayer(Player player){
		PlayerDE playerToSave = PlayerMapper.mapDE(player);
		playerRepository.save(playerToSave);
	}


}
