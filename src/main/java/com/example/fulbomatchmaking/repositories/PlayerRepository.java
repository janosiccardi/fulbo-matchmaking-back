package com.example.fulbomatchmaking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.fulbomatchmaking.business.player.model.PlayerDE;


@Repository
public interface PlayerRepository extends JpaRepository<PlayerDE, String>, JpaSpecificationExecutor<PlayerDE> {
	List<PlayerDE> findByCuenta(int cuenta);
	
	void deleteByNameAndCuenta(String name, Integer cuenta);
	
	PlayerDE findByNameAndCuenta(String name, Integer cuenta);

}
