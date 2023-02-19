package com.example.fulbomatchmaking.business.generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.fulbomatchmaking.business.generator.model.GenerateTeamsRequest;
import com.example.fulbomatchmaking.business.generator.model.GenerateTeamsResponse;
import com.example.fulbomatchmaking.business.player.model.Player;

@Service
public class TeamGeneratorService {

	public GenerateTeamsResponse generateTeams(GenerateTeamsRequest request) {
		List<Player> players = request.getPlayers();
	    Map<List<Player>,List<Player>> combinations = new HashMap<>();
	    for (int i = 0; i < 10; i++) {
	      for (int j = i + 1; j < 10; j++) {
	        for (int k = j + 1; k < 10; k++) {
	          for (int l = k + 1; l < 10; l++) {
	            for (int m = l + 1; m < 10; m++) {
	              List<Player> group1 = new ArrayList<>();
	              group1.add(players.get(i));
	              group1.add(players.get(j));
	              group1.add(players.get(k));
	              group1.add(players.get(l));
	              group1.add(players.get(m));
	              List<Player> group2 = players.stream().filter(p -> !group1.contains(p)).collect(Collectors.toList());
	              double group1Score = getAverage(group1,request.isSmpMode());
	              double group2Score = getAverage(group2,request.isSmpMode());
	              if (Math.abs(group1Score - group2Score) <= 1) {
	                combinations.put(group1,group2);
	              }
	            }
	          }
	        }
	      }
	    }
	    GenerateTeamsResponse response = new GenerateTeamsResponse();
	    List<Player> randomTeam = (List<Player>) combinations.keySet().toArray()[0];
	    List<Player> randomTeam2 = combinations.get(randomTeam);
	    response.setTeam1(randomTeam);
	    response.setTeam2(randomTeam2);
	    return response;
	}
	
	public GenerateTeamsResponse generateTeams2(GenerateTeamsRequest request) {
		List<Player> players = request.getPlayers();
	    Map<List<Player>,List<Player>> combinations = new HashMap<>();
	    for (int i = 0; i < 10; i++) {
	      for (int j = i + 1; j < 10; j++) {
	        for (int k = j + 1; k < 10; k++) {
	          for (int l = k + 1; l < 10; l++) {
	              List<Player> group1 = new ArrayList<>();
	              group1.add(players.get(i));
	              group1.add(players.get(j));
	              group1.add(players.get(k));
	              group1.add(players.get(l));
	              List<Player> group2 = players.stream().filter(p -> !group1.contains(p)).collect(Collectors.toList());
	              double group1Score = getAverage(group1,request.isSmpMode());
	              double group2Score = getAverage(group2,request.isSmpMode());
	              if (Math.abs(group1Score - group2Score) <= 1) {
	                combinations.put(group1,group2);
	              
	            }
	          }
	        }
	      }
	    }
	    GenerateTeamsResponse response = new GenerateTeamsResponse();
	    List<Player> randomTeam = (List<Player>) combinations.keySet().toArray()[0];
	    List<Player> randomTeam2 = combinations.get(randomTeam);
	    response.setTeam1(randomTeam);
	    response.setTeam2(randomTeam2);
	    return response;
	}
	
	
	private double getAverage(List<Player> team, boolean smpMode) {
		double total = 0;
		for(Player player : team) {
			total += smpMode? player.getOverallSmp() : player.getOverall() ;
		}
		return total / team.size();
	}

}
