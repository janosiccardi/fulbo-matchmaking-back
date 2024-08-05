package com.example.fulbomatchmaking.business.team.model;

import java.util.List;

import com.example.fulbomatchmaking.business.account.model.Account;
import com.example.fulbomatchmaking.business.account.model.AccountTO;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TeamTO{
	private Long id;
	private String name;
	private List<Long> associatedUsers;
	private List<Long> admins;
	private List<AccountTO> users;

}