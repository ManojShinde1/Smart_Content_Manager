package com.manager.smartcontactmanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.manager.smartcontactmanager.services.EmailService;

@SpringBootTest
public class EmailSenderTest {
	
	@Autowired
	private EmailService emailService;

//	Send email to single person
	@Test
	void emailSendTest() {
		System.out.println("Sending email");
		emailService.sendEmail("manojshinde0990@gmail.com", "Email From Spring Boot", "My name is nikita from taleranwadi kesanand");
	}
	
//	send email with html
	@Test
	void sendHtmlInMail(){
		
		String html = ""+
					"<h1 style='color:red;border:1px solid red;'>Welcome to the Manoj Shinde Vlogs</h1>"+
				"";
		
		emailService.sendEmailWithHtml("manojshinde0990@gmail.com", "Email From Spring Boot", html);
		
	}
	
//	send email with file
	@Test
	void sendEmailWithFile() {
	emailService.sendEmailWithFile("manojshinde0990@gmail.com", "Email with file", "Email Contails file", new File("C:\\Users\\Shree\\Downloads\\Smart-Contact-Manager\\src\\main\\resources\\profile.png"));
	}
	
	
//	send email with file InputStream with save file in giving folder
	@Test
	void sendEmailWithFileStream() {
		
		File file = new File("C:\\Users\\Shree\\git\\Smart_Content_Manager\\Smart-Contact-Manager\\src\\main\\resources\\profile.png");
		
		try {
		InputStream is = new FileInputStream(file);
		emailService.sendEmailWithFiles("manojshinde0990@gmail.com",
									"Email with file", 
									"Email Contails file", is);
		}catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
}
