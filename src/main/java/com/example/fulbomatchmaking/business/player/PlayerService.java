package com.example.fulbomatchmaking.business.player;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.fulbomatchmaking.business.player.model.DeletePlayerRequest;
import com.example.fulbomatchmaking.business.player.model.Player;
import com.example.fulbomatchmaking.business.player.model.PlayerDE;
import com.example.fulbomatchmaking.repositories.PlayerRepository;

import jakarta.transaction.Transactional;

@Service
public class PlayerService {
	
	@Autowired 
	@Qualifier("playerRepository")
	private PlayerRepository playerRepository;
	
	public List<Player> getPlayers(int id) {
		List<PlayerDE> des = playerRepository.findByCuenta(id);
		return PlayerMapper.mapTOList(des);
	}

	public double getOverall(Player player) {		
	    return (((player.getFinishing() * 10 + player.getPassing() * 8 + player.getDribbling() * 10 + player.getDefending() * 7 + 
	      player.getSpeed() * 5 + player.getStrength() * 6 + player.getStamina() * 9 + player.getAggression() * 2 + player.getComposure() * 5 + 
	      player.getPositioning() * 9 + player.getVision() * 7 + player.getTechnique() * 8) / 12) / 10) + 30;
	 }
	@Transactional
	public void deletePlayer(DeletePlayerRequest request) {
		playerRepository.deleteByNameAndCuenta(request.getPlayerName(), request.getId());
	}
	@Transactional
	public void addPlayer(PlayerDE player) throws Exception{
		PlayerDE exist = playerRepository.findByNameAndCuenta(player.getName(), player.getCuenta());
		if(exist == null) {
		   playerRepository.save(player);
		}else {
			throw new Exception("This player already exist!");
		}
	}
	

	@Transactional
	public void updatePlayer(PlayerDE player){
		playerRepository.save(player);
	}


}
