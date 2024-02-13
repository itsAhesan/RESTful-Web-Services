package com.jony.spring_boot.service;

import java.util.List;

import com.jony.spring_boot.model.Email;
import com.jony.spring_boot.model.Member;

public interface MemberService {

	Member add(Member member);

	

	Member checkMember(String name, String pass);



	Member send(String to);



	void save(Email email);



	List<Email> checkEmail(String to);



	List<Email> checkSender(String from);



	Email deleteInbox(int eid);



	Email sentInbox(int eid);



	List<Email> drafts(String from);



	/* void relation(int id, int id2); */



//	Member checkName(String name);



//	Email sentEmail(String to);




}
