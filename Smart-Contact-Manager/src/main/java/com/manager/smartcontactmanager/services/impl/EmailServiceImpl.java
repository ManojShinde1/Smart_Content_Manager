package com.manager.smartcontactmanager.services.impl;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.manager.smartcontactmanager.services.EmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
@Service("EmailService")
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	private JavaMailSender mailSender;
	
	private Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

//	public EmailServiceImpl(JavaMailSender mailSender) {
//		super();
//		this.mailSender = mailSender;
//	}

//	Send email to single person
	@Override
	public void sendEmail(String to, String subject, String message) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(message);
		simpleMailMessage.setFrom("manojshindevlogs@gmail.com");
		mailSender.send(simpleMailMessage);
		
		logger.info("Email has been sent..!");
		
	}

//	Send email to multiple person
	@Override
	public void sendEmailMul(String[] to, String subject, String message) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(to);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(message);
		simpleMailMessage.setFrom("manojshindevlogs@gmail.com");
		mailSender.send(simpleMailMessage );
		logger.info("Email has been sent..!");
		
	}

//	send email with html
	@Override
	public void sendEmailWithHtml(String to, String subject, String htmlContent) {
		
		MimeMessage simpleMailMessage = mailSender.createMimeMessage();
		
		try {
			MimeMessageHelper helper = new MimeMessageHelper(simpleMailMessage,true,"UTF-8");
			
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setFrom("manojshindevlogs@gmail.com");
			helper.setText(htmlContent, true);
			mailSender.send(simpleMailMessage );
			logger.info("Email has been sent..!");
		
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

//	send email with file
	public void sendEmailWithFile(String to, String subject, String message, File file) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			helper.setFrom("manojshindevlogs@gmail.com");
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(message);
			helper.setSubject(subject);
			FileSystemResource fileSystemResource = new FileSystemResource(file);
			helper.addAttachment(fileSystemResource.getFilename(), file);
			mailSender.send(mimeMessage);
			logger.info("Email send success");
		
		
		} catch (MessagingException e) {
			throw new RuntimeException(e); 
		}
		
	}

	
}
