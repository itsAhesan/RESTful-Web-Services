package com.jony.spring_boot.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jony.spring_boot.model.Email;

@Component
public class EmailResponse {

	private boolean error;
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
//	@JsonIgnore
	public List<Email> getEmail() {
		return email;
	}
	public void setEmail(List<Email> email) {
		this.email = email;
	}
	private String message;
	private List<Email> email;
	@Override
	public String toString() {
		return "EmailResponse [error=" + error + ", message=" + message + ", email=" + email + "]";
	}
	
}
