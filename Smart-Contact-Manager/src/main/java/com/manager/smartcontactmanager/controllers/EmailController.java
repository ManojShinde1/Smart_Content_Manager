package com.manager.smartcontactmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manager.smartcontactmanager.entities.CustomResponse;
import com.manager.smartcontactmanager.entities.EmailRequest;
import com.manager.smartcontactmanager.services.EmailService;

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {

	@Autowired
	private EmailService emailService;
	
//	send email
	@PostMapping("/send")
	public ResponseEntity<?>sendEmail(@RequestBody EmailRequest request){
		
		emailService.sendEmailWithHtml(request.getTo(),request.getSubject(), request.getMessage());		
	
	return ResponseEntity.ok(
			CustomResponse.
			);
	}
	
}
