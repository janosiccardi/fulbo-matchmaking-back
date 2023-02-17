package com.example.fulbomatchmaking.business.player;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.fulbomatchmaking.business.player.model.DeletePlayerRequest;
import com.example.fulbomatchmaking.business.player.model.Player;
import com.example.fulbomatchmaking.business.player.model.PlayerDE;
import com.example.fulbomatchmaking.repositories.PlayerRepository;
import com.example.utils.AES;

import jakarta.transaction.Transactional;

@Service
public class PlayerService {
	
	@Autowired 
	@Qualifier("playerRepository")
	private PlayerRepository playerRepository;
	
	public List<Player> getPlayers(String id) {
		String idS = AES.decrypt(id, "fmm2023");
		int account = Integer.parseInt(idS);
		List<PlayerDE> des = playerRepository.findByCuenta(account);
		return PlayerMapper.mapTOList(des);
	}
	@Transactional
	public void deletePlayer(DeletePlayerRequest request) {
		int account = Integer.parseInt(AES.decrypt(request.getId(), "fmm2023"));
		playerRepository.deleteByNameAndCuenta(request.getPlayerName(), account);
	}
	@Transactional
	public void addPlayer(Player player) throws Exception{
		int account = Integer.parseInt(AES.decrypt(player.getCuenta(), "fmm2023"));
		PlayerDE exist = playerRepository.findByNameAndCuenta(player.getName(), account);
		if(exist == null) {
			PlayerDE playerToSave = PlayerMapper.mapDE(player);
			playerToSave.setCuenta(account);
		   playerRepository.save(playerToSave);
		}else {
			throw new Exception("This player already exist!");
		}
	}
	

	@Transactional
	public void updatePlayer(Player player){
		int account = Integer.parseInt(AES.decrypt(player.getCuenta(), "fmm2023"));
		PlayerDE playerToSave = PlayerMapper.mapDE(player);
		playerToSave.setCuenta(account);
		playerRepository.save(playerToSave);
	}


}
