package com.jony.spring_boot.service;

import com.jony.spring_boot.model.UserDto;

public interface UserService {
	
	UserDto add(UserDto dto);
	
	UserDto read(int id);

	UserDto update(int id, UserDto dto);

	UserDto delete(int id);

}
