package com.org.SpringDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.SpringDemo.json.EmailJson;
import com.org.SpringDemo.json.MessageJson;
import com.org.SpringDemo.model.EmailModel;
import com.org.SpringDemo.model.VendorModel;
import com.org.SpringDemo.service.EmailService;

import com.org.SpringDemo.service.VendorService;

@RestController
@CrossOrigin
@RequestMapping("/api/email")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
    private VendorService vendorService;

    @PostMapping("/send")
    public String sendEmail(@RequestBody List<String> vendorEmails) {
        List<VendorModel> vendors = vendorService.getVendorsByEmails(vendorEmails);
        for (VendorModel vendor : vendors) {
            EmailModel email = new EmailModel();
            email.setRecipient(vendor.getEmail());
            email.setSubject("Payment Information");
            email.setBody("Sending payments to vendor " + vendor.getName() + " at upi " + vendor.getUpi());
            emailService.sendEmail(email);
        }
        return "Emails sent successfully!";
    }
	
 //=======================================================================
    //get all the email list
    
    @GetMapping("/getAllEmail")
    public List<EmailModel> getAllSentEmails() {
        return emailService.getAllSentEmails();
    }

	//============================================================================
	@PostMapping("/email")
	public ResponseEntity<EmailJson> addEmail(@RequestBody EmailJson emailJson){
		MessageJson mes=new MessageJson();
		mes=emailService.addEmail(emailJson);
		if(mes.getStatuscode()==400) {
			return new ResponseEntity<EmailJson>(HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<EmailJson>(HttpStatus.OK);
		}
	}
	

}
