package com.example.fulbomatchmaking.business.account.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AccountTO{
	private int id;
	private String us;
	private String pass;
	private String nickname;
	private Boolean smpMode;
	private List<Integer> teams;

}