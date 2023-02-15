package com.example.fulbomatchmaking.business.generator.model;

import java.util.List;

import com.example.fulbomatchmaking.business.player.model.Player;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenerateTeamsRequest {
	private List<Player> players;
}
