package com.example.fulbomatchmaking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.fulbomatchmaking.business.count.model.Count;


@Repository
public interface CountRepository extends JpaRepository<Count, Long>, JpaSpecificationExecutor<Count> {
	Count findByUsAndPass(String us, String pass);

}
