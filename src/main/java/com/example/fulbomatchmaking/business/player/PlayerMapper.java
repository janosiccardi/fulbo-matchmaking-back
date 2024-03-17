package com.example.fulbomatchmaking.business.player;

import java.util.List;
import java.util.stream.Collectors;

import com.example.fulbomatchmaking.business.player.model.Player;
import com.example.fulbomatchmaking.business.player.model.PlayerDE;
import com.example.fulbomatchmaking.repositories.keys.PlayerCompKey;

public class PlayerMapper {

	public static List<Player> mapTOList(List<PlayerDE> des) {
		return des.stream().map(PlayerMapper::mapTO).collect(Collectors.toList());
	}

	public static Player mapTO(PlayerDE de) {
		Player to = new Player();
		 to.setName(de.getId().getName());
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
		 to.setTeam(de.getId().getTeam());
		 to.setOverallSmp(de.getOverallSmp() != null ? de.getOverallSmp() : getOverall(to));
		return to;

	}

	public static PlayerDE mapDE(Player to) {
		PlayerDE de = new PlayerDE();
		PlayerCompKey key = new PlayerCompKey();
		key.setName(to.getName());
		key.setTeam(to.getTeam());		
		de.setId(key);
		 de.setFinishing(nullOrZero(to.getFinishing()));
		 de.setPassing(nullOrZero(to.getPassing()));
		 de.setDribbling(nullOrZero(to.getDribbling()));
		 de.setDefending(nullOrZero(to.getDefending()));
		 de.setSpeed(nullOrZero(to.getSpeed()));
		 de.setStrength(nullOrZero(to.getStrength()));
		 de.setStamina(nullOrZero(to.getStamina()));
		 de.setAggression(nullOrZero(to.getAggression()));
		 de.setComposure(nullOrZero(to.getComposure()));
		 de.setPositioning(nullOrZero(to.getPositioning()));
		 de.setVision(nullOrZero(to.getVision()));
		 de.setTechnique(nullOrZero(to.getTechnique()));
		 de.setOverallSmp(nullOrZero(to.getOverallSmp()));
		return de;

	}

	public static Double nullOrZero(Double valor) {
		System.out.println(valor);
		if(valor == 0.0) {
			return null;
		}else {
			return valor;
		}
	}

	public static float nullOrZero(float valor) {
		if(valor > 0) {
			return valor;
		}else {
			return 1;
		}
	}

	public static double getOverall(Player player) {
	    return (((player.getFinishing() * 10 + player.getPassing() * 8 + player.getDribbling() * 9 + player.getDefending() * 9 +
	      player.getSpeed() * 5 + player.getStrength() * 6 + player.getStamina() * 6 + player.getAggression() * 1 + player.getComposure() * 5 +
	      player.getPositioning() * 9 + player.getVision() * 7 + player.getTechnique() * 7) / 12) / 10) + 31.3;
	  }

}
