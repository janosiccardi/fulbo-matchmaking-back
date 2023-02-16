package com.example.fulbomatchmaking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.example.fulbomatchmaking.business.account.model.Account;
import com.example.fulbomatchmaking.business.count.model.Count;


@Repository
public interface AccountRepository extends JpaRepository<Account, Long>, JpaSpecificationExecutor<Account> {
	Account findByUsAndPass(String us, String pass);

}
