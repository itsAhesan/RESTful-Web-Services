package com.jony.spring_boot.response;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jony.spring_boot.model.Email;

@Component
public class EResponse {

	private List<Email> lEmails;

	public List<Email> getlEmails() {
		return lEmails;
	}

	public void setlEmails(List<Email> lEmails) {
		this.lEmails = lEmails;
	}
	
}
