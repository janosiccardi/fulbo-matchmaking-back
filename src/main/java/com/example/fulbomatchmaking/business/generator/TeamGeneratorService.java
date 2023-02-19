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
		int size = players.size();
		Map<List<Player>, List<Player>> combinations = new HashMap<>();
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				for (int k = j + 1; k < size; k++) {
					for (int l = k + 1; l < size; l++) {
						if (size != 8) {
							for (int m = l + 1; m < size; m++) {
								if (size != 10) {
									for (int n = l + 1; n < size; n++) {
										calculateCombinations(request, players, combinations, i, j, k, l, m, n);
									}
								} else {
									calculateCombinations(request, players, combinations, i, j, k, l, m, null);
								}
							}
						} else {
							calculateCombinations(request, players, combinations, i, j, k, l, null, null);
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
		response.setCombinationQty(combinations.size());
		return response;
	}

	private void calculateCombinations(GenerateTeamsRequest request, List<Player> players,
			Map<List<Player>, List<Player>> combinations, Integer i, Integer j, Integer k, Integer l, Integer m,
			Integer n) {
		List<Player> group1 = new ArrayList<>();
		group1.add(players.get(i));
		group1.add(players.get(j));
		group1.add(players.get(k));
		group1.add(players.get(l));
		if (m != null) {
			group1.add(players.get(m));
		}
		if (n != null) {
			group1.add(players.get(n));
		}
		List<Player> group2 = players.stream().filter(p -> !group1.contains(p)).collect(Collectors.toList());
		double group1Score = getAverage(group1, request.isSmpMode());
		double group2Score = getAverage(group2, request.isSmpMode());
		if (Math.abs(group1Score - group2Score) <= 1) {
			combinations.put(group1, group2);
		}
	}

	private double getAverage(List<Player> team, boolean smpMode) {
		double total = 0;
		for (Player player : team) {
			total += smpMode ? player.getOverallSmp() : player.getOverall();
		}
		return total / team.size();
	}

}
