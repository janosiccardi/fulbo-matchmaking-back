package com.example.fulbomatchmaking.business.player.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.example.fulbomatchmaking.repositories.keys.PlayerCompKey;

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
	
	@EmbeddedId PlayerCompKey id;


	
	@Column(name = "name", nullable = false,insertable=false, updatable=false)
	private String name;
	
	@Column(name = "team", nullable = false,insertable=false, updatable=false)
	private int team;

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

	@Column(name = "overall_smp")
	private Double overallSmp;	
	
	@Column(name = "goalkeeper")
	private Boolean goalkeeper;

	@Column(name = "handling")
	private float handling;

	@Column(name = "kicking")
	private float kicking;

	@Column(name = "positioning2")
	private float positioning2;

	@Column(name = "diving")
	private float diving;

	@Column(name = "reflex")
	private float reflex;

	@Column(name = "rejection")
	private float rejection;


}