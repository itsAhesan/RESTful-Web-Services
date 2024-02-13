package com.jony.spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jony.spring_boot.model.Member;

public interface MemberRepo extends JpaRepository<Member, Integer>{
	
	@Query("SELECT e FROM Member e WHERE e.name = :name and e.pass= :pass ")
	Member findByName(String name, String pass);
	
	@Query("SELECT e FROM Member e WHERE e.name = :to")
	Member findBy(String to);
	
	/*
	 * @Query("SELECT e FROM Member e WHERE e.name = :name") Member
	 * findBymName(String name);
	 */

}
