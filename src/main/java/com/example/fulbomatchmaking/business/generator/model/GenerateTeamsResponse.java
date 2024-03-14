package com.example.fulbomatchmaking.business.generator.model;

import java.util.List;

import com.example.fulbomatchmaking.business.player.model.Player;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenerateTeamsResponse {
	private List<Player> team1;
	private List<Player> team2;
	private Integer combinationQty;

}
