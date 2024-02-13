package com.jony.spring_boot.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Email {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	
	@Column(name = "sender")
	private String from;
	@Column(name = "receiver")
	private String to;
	private String subject;
	private String body;
	
	@JsonIgnore
	private int emailDelete;
	
	
	
	@JsonIgnore
	private int emailDrafts;
	
	@JsonIgnore
	private int emailSent;
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * @ManyToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "member_email", joinColumns = @JoinColumn(name= "eid"),
	 * inverseJoinColumns = @JoinColumn(name="mid")) private List<Member> member;
	 */
	
	
	
	
	
	public int getEmailSent() {
		return emailSent;
	}
	public void setEmailSent(int emailSent) {
		this.emailSent = emailSent;
	}
	public int getEmailDelete() {
		return emailDelete;
	}
	public void setEmailDelete(int emailDelete) {
		this.emailDelete = emailDelete;
	}
	public int getEmailDrafts() {
		return emailDrafts;
	}
	public void setEmailDrafts(int emailDrafts) {
		this.emailDrafts = emailDrafts;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "Email [id=" + eid + ", from=" + from + ", to=" + to + ", subject=" + subject + ", body=" + body + "]";
	}
	
	
	
	
	

}
