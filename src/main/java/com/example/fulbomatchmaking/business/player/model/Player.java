package com.example.fulbomatchmaking.business.player.model;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {

	@Override
	public String toString() {
		return "Player [name=" + name + ", finishing=" + finishing + ", passing=" + passing + ", technique=" + technique
				+ ", dribbling=" + dribbling + ", speed=" + speed + ", strength=" + strength + ", defending="
				+ defending + ", aggression=" + aggression + ", stamina=" + stamina + ", positioning=" + positioning
				+ ", vision=" + vision + ", composure=" + composure + ", overall=" + overall + "] \n ";
	}

	private String name;

    //Attacking
    private float finishing;
    private float passing;
    private float technique;

    //Skill
    private float dribbling;
    private float speed;
    private float strength;

    //Defending
    private float defending;
    private float aggression;
    private float stamina;

    //Mentallity
    private float positioning;
    private float vision;
    private float composure;

    private double overall;
    private double overallSmp;
    private Integer team;
	private Boolean goalkeeper;
	private float handling;
	private float kicking;
	private float positioning2;
	private float diving;
	private float reflex;
	private float rejection;

	}
