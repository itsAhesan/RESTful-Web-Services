package com.jony.spring_boot.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jony.spring_boot.model.UserDto;

@Component
public class UserResponse {
	
	private boolean error;
	private String message;
	private List<UserDto> dto;
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<UserDto> getDto() {
		return dto;
	}
	public void setDto(List<UserDto> dto) {
		this.dto = dto;
	}
	
	
	
	

}
