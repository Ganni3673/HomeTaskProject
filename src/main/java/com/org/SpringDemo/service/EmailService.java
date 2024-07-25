package com.org.SpringDemo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.SpringDemo.json.EmailJson;
import com.org.SpringDemo.json.EmployeeJson;
import com.org.SpringDemo.json.MessageJson;
import com.org.SpringDemo.model.EmailModel;
import com.org.SpringDemo.model.EmployeeModel;
import com.org.SpringDemo.model.VendorModel;
import com.org.SpringDemo.repository.EmailRepo;

@Service
public class EmailService {
	
	@Autowired
	private EmailRepo emailRepo;
	

	public MessageJson addEmail(EmailJson emailJson) {
		
		MessageJson mess=new MessageJson();
		Optional<EmailModel> mod=emailRepo.findByIdEmail(emailJson.getId());
		if(mod.isPresent()) {
			mess.setMessage("already email is prasent in data base");
			mess.setStatuscode(400);
		}else {
			EmailModel me=new EmailModel();
			me.setId(emailJson.getId());
			me.setRecipient(emailJson.getRecipient());
			me.setSubject(emailJson.getSubject());
			me.setBody(emailJson.getBody());
			
			emailRepo.save(me);
			
			mess.setMessage("new email data added successfully");
			mess.setStatuscode(200);
		}
		return mess;
	}

//=============================================================================
	
		private List<EmailModel> sentEmails = new ArrayList<>();

	    public void sendEmail(EmailModel email) {
	        // Mock sending email by printing to console
	        System.out.println("Sending email to: " + email.getRecipient());
	        System.out.println("Subject: " + email.getSubject());
	        System.out.println("Body: " + email.getBody());
	        sentEmails.add(email);
	    }
//=====================================================================================
	    
	    
		public List<EmailModel> getAllSentEmails() {
			

			
			List<EmailModel> list=new ArrayList<EmailModel>();
			Collection<EmailModel> mod=emailRepo.findAll();
			
			for(EmailModel empd:mod) {
				list.add(empd);
				
				
			}
			
			return list;
		}

	
}

			
		

//====================================================================================


   
//================================================================================================================