package com.example.fulbomatchmaking.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.fulbomatchmaking.business.player.model.PlayerDE;
import com.example.fulbomatchmaking.repositories.keys.PlayerCompKey;


@Repository
public interface PlayerRepository extends JpaRepository<PlayerDE, PlayerCompKey>, JpaSpecificationExecutor<PlayerDE> {
	List<PlayerDE> findByTeam(int group);

	void deleteByNameAndTeam(String name, Integer team);

	PlayerDE findByNameAndTeam(String name, Integer team);

}
