package com.example.fulbomatchmaking.business.player.model;

import java.io.Serializable;


import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "player")
@Component
public class PlayerDE implements Serializable {

	private static final long serialVersionUID = 6094407212788597216L;

	@Id
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "finishing")
	private float finishing;

	@Column(name = "passing")
	private float passing;

	@Column(name = "dribbling")
	private float dribbling;

	@Column(name = "defending")
	private float defending; 
	 
	@Column(name = "speed")
	private float speed; 
	 
	@Column(name = "strength")
	private float strength;

	@Column(name = "stamina")
	private float stamina;

	@Column(name = "aggression")
	private float aggression;

	@Column(name = "composure")
	private float composure;

	@Column(name = "positioning")
	private float positioning;

	@Column(name = "vision")
	private float vision;

	@Column(name = "technique")
	private float technique;
	
	@Column(name = "cuenta")
	private int cuenta;
	
	@Column(name = "overall_smp")
	private Double overallSmp;

}