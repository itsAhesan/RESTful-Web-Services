package com.jony.spring_boot.response;

import java.util.List;

import org.springframework.stereotype.Component;


import com.jony.spring_boot.model.Member;


@Component
public class MemberResponse {
	
	private boolean error;
	private String message;
	private List<Member> member;

	
	
	
	
	
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
	public List<Member> getMember() {
		return member;
	}
	public void setMember(List<Member> member) {
		this.member = member;
	}
	
	

}
