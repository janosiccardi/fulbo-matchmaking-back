package com.example.fulbomatchmaking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.fulbomatchmaking.business.account.model.AccountDE;


@Repository
public interface AccountRepository extends JpaRepository<AccountDE, Long>, JpaSpecificationExecutor<AccountDE> {
	AccountDE findByUsAndPass(String us, String pass);
	
	@Modifying(clearAutomatically = true)
	@Query(value = "update `cuenta` set `smp_mode` = :smpMode \n"
			+ "WHERE `ID` = :account ", nativeQuery = true)
	void saveModeByAccount(@Param("smpMode") Boolean smpMode, @Param("account") int account);

}
