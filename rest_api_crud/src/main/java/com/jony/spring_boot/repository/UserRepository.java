package com.jony.spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jony.spring_boot.model.UserDto;

public interface UserRepository extends JpaRepository<UserDto, Integer>{

}
