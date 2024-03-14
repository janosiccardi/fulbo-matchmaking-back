package com.example.fulbomatchmaking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.fulbomatchmaking.business.team.model.Team;


@Repository
public interface TeamRepository extends JpaRepository<Team, Long>, JpaSpecificationExecutor<Team> {

}
