package com.jony.spring_boot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jony.spring_boot.model.Email;
import com.jony.spring_boot.model.Member;
import com.jony.spring_boot.repository.EmailRepo;
import com.jony.spring_boot.response.EmailResponse;
import com.jony.spring_boot.response.MemberResponse;
import com.jony.spring_boot.service.ServiceImpl;

@RestController
public class MyController {

	@Autowired
	private MemberResponse response;

	@Autowired
	private EmailResponse eResponse;

	@Autowired
	private ServiceImpl service;
	
	@Autowired
	private EmailRepo eRepo;
	

	@PostMapping("/registration")
	public ResponseEntity<MemberResponse> registration(@RequestBody Member member) {

		Member add = service.add(member);

		if (add != null) {
			response.setError(false);
			response.setMessage("Registration Done");
			response.setMember(Arrays.asList(add));

			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setMessage("Registration Failed");
			response.setMember(null);

			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

		}
	}

	@PostMapping("/login")
	public ResponseEntity<MemberResponse> loginCheck(@RequestBody Member member) {

		Member user = service.checkMember(member.getName(), member.getPass());

		if (user != null) {
			response.setError(false);
			response.setMessage("Login Success");
			response.setMember(Arrays.asList(user));

			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setMessage("Login Failed");
			response.setMember(null);

			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

		}
	}

	@PostMapping("/sendEmail")
	public ResponseEntity<MemberResponse> send(@RequestBody Email email) {

		// Member user = service.checkMember(member.getName(),member.getPass());
		System.out.println(email);
		Member send = service.send(email.getTo());
		System.out.println(send);
			
		if(email.getEid()!=0) {			// =======Remove from draft ========
			service.changeDraft(email);
		}else if (send != null) {		//========Sent mail=========
			service.save(email);
			
		}else {								//========Drafts Messages========
			email.setEmailDrafts(1);
			eRepo.save(email);
		}

		if (send != null) {
			response.setError(false);
			response.setMessage("Email send Success");

			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setMessage("Failed to send");

			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

		}
	}

	@GetMapping("/inbox")
	public ResponseEntity<EmailResponse> inbox(@RequestBody Email email) {

		// Member user = service.checkMember(member.getName(),member.getPass());
		List<Email> list = service.checkEmail(email.getTo());
		
		
		System.out.println(list);

		/*
		 * Member member = service.checkName(mem.getName());
		 * System.out.println("Member " + member);
		 * 
		 * List<Email> email = member.getEmail();
		 * 
		 * System.out.println("Email " + email);
		 * 
		 * for (Email email2 : email) { System.out.println(email2.getBody()); }
		 */

		if (list != null) {
			eResponse.setError(false);

			eResponse.setMessage("Your Inbox");
			eResponse.setEmail(list);

			return new ResponseEntity<EmailResponse>(eResponse, HttpStatus.OK);
		} else {
			eResponse.setError(true);
			eResponse.setMessage("No Emails");
			eResponse.setEmail(null);

			return new ResponseEntity<EmailResponse>(eResponse, HttpStatus.NOT_FOUND);

		}

	}

	@GetMapping("/sent")
	public ResponseEntity<EmailResponse> sent(@RequestBody Email email) {

		// Member user = service.checkMember(member.getName(),member.getPass());
		List<Email> sender = service.checkSender(email.getFrom());
		System.out.println(sender);
		
		for (Email email2 : sender) {
			System.out.println(email2);
		}

		if (sender != null) {
			eResponse.setError(false);

			eResponse.setMessage("Your sent messages");
			eResponse.setEmail(sender);

			return new ResponseEntity<EmailResponse>(eResponse, HttpStatus.OK);
		} else {
			eResponse.setError(true);
			eResponse.setMessage("No Emails");
			eResponse.setEmail(null);

			return new ResponseEntity<EmailResponse>(eResponse, HttpStatus.NOT_FOUND);

		}

	}

	@GetMapping("/setNull")
	public ResponseEntity<EmailResponse> deleteInbox(@RequestBody Email email) {

		// Member user = service.checkMember(member.getName(),member.getPass());
		Email delete = service.delete(email.getEid());

		if (delete != null) {
			eResponse.setError(false);

			eResponse.setMessage("Your mail Deleted Successfully");
			// eResponse.setEmail(list);

			return new ResponseEntity<EmailResponse>(eResponse, HttpStatus.OK);
		} else {
			eResponse.setError(true);
			eResponse.setMessage("No Emails");
			// eResponse.setEmail(null);

			return new ResponseEntity<EmailResponse>(eResponse, HttpStatus.NOT_FOUND);

		}

	}

	@GetMapping("/inboxDelete")
	public ResponseEntity<EmailResponse> delete(@RequestBody Email email) {

		// Member user = service.checkMember(member.getName(),member.getPass()); //
	//	Email delete = service.delete(email.getEid());
		
		
		Email delete = service.deleteInbox(email.getEid());

		if (delete != null) {
			eResponse.setError(false);

			eResponse.setMessage("Your mail Deleted Successfully"); //
	//		eResponse.setEmail(list);

			return new ResponseEntity<EmailResponse>(eResponse, HttpStatus.OK);
		} else {
			eResponse.setError(true);
			eResponse.setMessage("No Emails"); //
	//		eResponse.setEmail(null);

			return new ResponseEntity<EmailResponse>(eResponse, HttpStatus.NOT_FOUND);

		}

	}
	
	@GetMapping("/sentDelete")
	public ResponseEntity<EmailResponse> sentDelete(@RequestBody Email email) {

		// Member user = service.checkMember(member.getName(),member.getPass()); //
	//	Email delete = service.delete(email.getEid());
		
		
		Email delete = service.sentInbox(email.getEid());

		if (delete != null) {
			eResponse.setError(false);

			eResponse.setMessage("Your mail Deleted Successfully"); //
	//		eResponse.setEmail(list);

			return new ResponseEntity<EmailResponse>(eResponse, HttpStatus.OK);
		} else {
			eResponse.setError(true);
			eResponse.setMessage("No Emails"); //
	//		eResponse.setEmail(null);

			return new ResponseEntity<EmailResponse>(eResponse, HttpStatus.NOT_FOUND);

		}

	}
	
	@GetMapping("/drafts")
	public ResponseEntity<EmailResponse> drafts(@RequestBody Email email) {

		// Member user = service.checkMember(member.getName(),member.getPass()); //
	//	Email delete = service.delete(email.getEid());
		
		
		List<Email> drafts = service.drafts(email.getFrom());
		System.out.println(drafts);

		if (drafts != null) {
			eResponse.setError(false);

			eResponse.setMessage("Your Draft messages"); //
			eResponse.setEmail(drafts);

			return new ResponseEntity<EmailResponse>(eResponse, HttpStatus.OK);
		} else {
			eResponse.setError(true);
			eResponse.setMessage("No Emails"); //
			eResponse.setEmail(null);

			return new ResponseEntity<EmailResponse>(eResponse, HttpStatus.NOT_FOUND);

		}

	}
	
	
	
	
	
	
	

	/*
	 * @GetMapping("/sent") public ResponseEntity<EmailResponse> sent(@RequestBody
	 * Email email){
	 * 
	 * System.out.println(email);
	 * 
	 * 
	 * // Member user = service.checkMember(member.getName(),member.getPass());
	 * Email sentEmail = service.sentEmail(email.getTo());
	 * 
	 * System.out.println("Member "+sentEmail);
	 * 
	 * List<Member> member = sentEmail.getMember();
	 * 
	 * System.out.println("Email "+member);
	 * 
	 * 
	 * 
	 * 
	 * if (email!=null) { eResponse.setError(false);
	 * 
	 * eResponse.setMessage("Your Inbox"); // eResponse.setEmail(email);
	 * 
	 * 
	 * return new ResponseEntity<>(eResponse, HttpStatus.OK); } else {
	 * eResponse.setError(true); // eResponse.setMessage("No Emails"); //
	 * eResponse.setEmail(null);
	 * 
	 * return new ResponseEntity<>(eResponse, HttpStatus.NOT_FOUND);
	 * 
	 * }
	 * 
	 * return new ResponseEntity<>(eResponse, HttpStatus.OK);
	 * 
	 * }
	 */
	/*
	 * @GetMapping("/sent") public ResponseEntity<EmailResponse> sent(@RequestBody
	 * Email email) {
	 * 
	 * System.out.println(email);
	 * 
	 * // Member user = service.checkMember(member.getName(),member.getPass());
	 * Email sentEmail = service.sentEmail(email.getFrom());
	 * 
	 * System.out.println("Member " + sentEmail);
	 * 
	 * List<Member> member = sentEmail.getMember();
	 * 
	 * System.out.println("Email " + member);
	 * 
	 * 
	 * if (email!=null) { eResponse.setError(false);
	 * 
	 * eResponse.setMessage("Your Inbox"); // eResponse.setEmail(email);
	 * 
	 * 
	 * return new ResponseEntity<>(eResponse, HttpStatus.OK); } else {
	 * eResponse.setError(true); // eResponse.setMessage("No Emails"); //
	 * eResponse.setEmail(null);
	 * 
	 * return new ResponseEntity<>(eResponse, HttpStatus.NOT_FOUND);
	 * 
	 * }
	 * 
	 * return new ResponseEntity<>(eResponse, HttpStatus.OK);
	 * 
	 * }
	 */

}
