package com.example.fulbomatchmaking.business.account.model;

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
@Table(name = "cuenta")
@Component
public class Account implements Serializable {

	private static final long serialVersionUID = 6094407212788597216L;

	@Id
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "us")
	private String us;
	
	@Column(name = "pass")
	private String pass;
	
	@Column(name = "nickname")
	private String nickname;

}