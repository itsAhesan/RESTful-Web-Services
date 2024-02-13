package com.jony.spring_boot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.jony.spring_boot.model.UserDto;
import com.jony.spring_boot.repository.UserRepository;

@Service
public class ServiceImp implements UserService {

	@Autowired
	private UserRepository repo;

	@Override
	public UserDto add(UserDto dto) {
		UserDto save = repo.save(dto);

		return save;

	}

	@Override
	public UserDto read(int id) {
		UserDto findById = repo.findById(id).orElse(null);

		return findById;

	}

	@Override
	public UserDto update(int id, UserDto dto) {
		UserDto findById = repo.findById(id).orElse(null);

		if (findById != null) {
			findById.setName(dto.getName());
			findById.setPass(dto.getPass());
			UserDto update = repo.save(findById);
			return update;
		} else {
			return null;
		}

	}

	@Override
	public UserDto delete(int id) {
		UserDto delete = repo.findById(id).orElse(null);

		if (delete != null) {
			repo.delete(delete);
			return delete;
		} else {
			return null;
		}

	}

}
