package com.example.fulbomatchmaking.business.player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.fulbomatchmaking.business.player.model.Player;
import com.example.fulbomatchmaking.business.player.model.PlayerDE;
import com.example.fulbomatchmaking.repositories.keys.PlayerCompKey;

public class PlayerMapper {

	public static List<Player> mapTOList(List<PlayerDE> des, PlayerDE overall) {
		List<Player> ret = new ArrayList<Player>();
		des.stream().forEach(de ->{
			ret.add(mapTO(de,overall));
		});
		
		return ret;
	}

	public static Player mapTO(PlayerDE de, PlayerDE overall) {
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
		 to.setTeam(de.getId().getTeam());
		 to.setOverallSmp(de.getOverallSmp() != null ? de.getOverallSmp() : getOverall(to,overall));
		 to.setGoalkeeper(de.getGoalkeeper());
		 to.setHandling(de.getHandling());
		 to.setDiving(de.getDiving());
		 to.setPositioning2(de.getPositioning2());
		 to.setKicking(de.getKicking());
		 to.setReflex(de.getReflex());
		 to.setRejection(nullOrZero(de.getRejection()));
		 to.setOverall(getOverall(to,overall));
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
		 de.setGoalkeeper(to.getGoalkeeper());
		 de.setHandling(nullOrZero(to.getHandling()));
		 de.setDiving(nullOrZero(to.getDiving()));
		 de.setPositioning2(nullOrZero(to.getPositioning2()));
		 de.setKicking(nullOrZero(to.getKicking()));
		 de.setReflex(nullOrZero(to.getReflex()));
		 de.setRejection(nullOrZero(to.getRejection()));
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

	public static double getOverall(Player player, PlayerDE overall) {
		if(player.getGoalkeeper() == null || !player.getGoalkeeper() ) {
			double ret = (((player.getFinishing() * overall.getFinishing() + 
		    		player.getPassing() * overall.getPassing() +
		    		player.getDribbling() * overall.getDribbling() + 
		    		player.getDefending() * overall.getDefending() +
		    		player.getSpeed() * overall.getSpeed() +
		    		player.getStrength() * overall.getStrength() + 
		    		player.getStamina() * overall.getStamina() + 
		    		player.getAggression() * overall.getAggression() +
		    		player.getComposure() * overall.getComposure() +
		    		player.getPositioning() * overall.getPositioning() +
		    		player.getVision() * overall.getVision() +
		    		player.getTechnique() * overall.getTechnique()) 
		    		/ 12) / 100) +8.75 ;
		    return ret + (ret* (overall.getOverallSmp()/100));
		}else {
			double ret = (((player.getPositioning2() * overall.getPositioning2() + 
		    		player.getHandling() * overall.getHandling() +
		    		player.getDiving() * overall.getDiving() + 
		    		player.getRejection() * overall.getRejection() +
		    		player.getReflex() * overall.getReflex() +
		    		player.getKicking() * overall.getKicking())
		    		/ 6) / 100);	
		    return ret + (ret* (overall.getOverallSmp()/100))+2.5;		
		}
	  }

}
