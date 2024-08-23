package com.manager.smartcontactmanager.services;

import java.io.File;
import java.io.InputStream;


public interface EmailService {

//	Send email to single person
	void sendEmail(String to, String subject, String message);
	
//	send email to multiple person
	void sendEmailMul(String []to, String subject, String message);
	
//	send email with html
	void sendEmailWithHtml(String to, String subject, String htmlContent);
	
//	send email with file
	void sendEmailWithFile(String to, String subject, String message, File file);
	
	void sendEmailWithFiles(String to, String subject, String message, InputStream is);
	
}
