package com.example.fulbomatchmaking.business.player;

import java.util.List;
import java.util.stream.Collectors;

import com.example.fulbomatchmaking.business.player.model.Player;
import com.example.fulbomatchmaking.business.player.model.PlayerDE;

public class PlayerMapper {
	
	public static List<Player> mapTOList(List<PlayerDE> des) {
		return des.stream().map(PlayerMapper::mapTO).collect(Collectors.toList());
	}
	
	public static Player mapTO(PlayerDE de) {
		Player to = new Player();
		 to.setName(de.getName());
		 to.setFinishing(de.getFinishing());
		 to.setPassing(de.getPassing());
		 to.setDribbling(de.getDribbling());
		 to.setDefending(de.getDefending());
		 to.setSpeed(de.getSpeed());
		 to.setStrength(de.getStrength());
		 to.setStamina(de.getStamina());
		 to.setAggression(de.getAggression());
		 to.setComposure(de.getComposure());
		 to.setPositioning(de.getPositioning());
		 to.setVision(de.getVision());
		 to.setTechnique(de.getTechnique());
		 to.setOverall(getOverall(to));
		return to;

	}
	
	public static double getOverall(Player player) {		
	    return (((player.getFinishing() * 10 + player.getPassing() * 8 + player.getDribbling() * 10 + player.getDefending() * 7 + 
	      player.getSpeed() * 5 + player.getStrength() * 6 + player.getStamina() * 9 + player.getAggression() * 2 + player.getComposure() * 5 + 
	      player.getPositioning() * 9 + player.getVision() * 7 + player.getTechnique() * 8) / 12) / 10) + 30;
	  }

}
