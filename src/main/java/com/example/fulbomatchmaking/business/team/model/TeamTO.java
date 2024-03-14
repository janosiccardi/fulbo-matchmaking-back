package com.example.fulbomatchmaking.business.team.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TeamTO{
	private Long id;
	private String name;
	private List<Integer> associatedUsers;

}