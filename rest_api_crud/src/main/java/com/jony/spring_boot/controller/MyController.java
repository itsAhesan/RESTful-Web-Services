package com.jony.spring_boot.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jony.spring_boot.model.UserDto;
import com.jony.spring_boot.response.UserResponse;
import com.jony.spring_boot.service.ServiceImp;

@RestController
public class MyController {

	@Autowired
	private ServiceImp service;

	@Autowired
	private UserResponse response;

	@PostMapping("/add")
	public ResponseEntity<UserResponse> add(@RequestBody UserDto dto) {
		UserDto saveDto = service.add(dto);

		if (saveDto != null) {
			response.setError(false);
			response.setMessage("Data Add Successfully");
			response.setDto(Arrays.asList(saveDto));

			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setMessage("Failed to Add");
			response.setDto(null);

			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/read/{id}")
	public ResponseEntity<UserResponse> read(@PathVariable int id) {
		UserDto read = service.read(id);

		if (read != null) {
			response.setError(false);
			response.setMessage("Data Read Successfully");
			response.setDto(Arrays.asList(read));

			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setMessage("Failed to Read");
			response.setDto(null);

			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/update/{id}")
	public ResponseEntity<UserResponse> update(@PathVariable int id, @RequestBody UserDto dto) {
		UserDto update = service.update(id,dto);

		if (update != null) {
			response.setError(false);
			response.setMessage("Data Update Successfully");
			response.setDto(Arrays.asList(update));

			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setMessage("Failed to Update");
			response.setDto(null);

			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}

	}
	
	@GetMapping("/delete/{id}")
	public ResponseEntity<UserResponse> delete(@PathVariable int id) {
		UserDto delete = service.delete(id);

		if (delete != null) {
			response.setError(false);
			response.setMessage("Data Delete Successfully");
			response.setDto(Arrays.asList(delete));

			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setMessage("Failed to Delete");
			response.setDto(null);

			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}

	}

}
