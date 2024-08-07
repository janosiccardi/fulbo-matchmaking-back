package com.example.fulbomatchmaking.business.account.model;

import java.util.List;

import com.example.fulbomatchmaking.business.team.model.Team;
import com.example.fulbomatchmaking.business.team.model.TeamTO;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AccountTO{
	private Long id;
	private String us;
	private String pass;
	private String nickname;
	private Boolean smpMode;
	private List<TeamTO> teams;
	private List<Long> groups;

}