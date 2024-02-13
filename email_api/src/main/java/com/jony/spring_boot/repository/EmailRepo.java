package com.jony.spring_boot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jony.spring_boot.model.Email;

public interface EmailRepo extends JpaRepository<Email, Integer>{
	
	@Query("SELECT e FROM Email e WHERE e.to = :to and e.emailDelete=0")
	List<Email> findByTo(String to);

	@Query("SELECT e FROM Email e WHERE e.from = :from and e.emailSent=0 and e.emailDrafts=0")
	List<Email> findByFrom(String from);
	@Query("SELECT e FROM Email e WHERE e.from = :from and e.emailDrafts=1")
	List<Email> findDrafts(String from);

	
	/*
	 * @Query("SELECT e FROM Email e WHERE e.from = :from") Email findByName(String
	 * from);
	 */

}
