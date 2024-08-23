package com.manager.smartcontactmanager.entities;

import org.springframework.http.HttpStatus;

import lombok.Builder;
@Builder
public class CustomResponse {

	private String message;
	private HttpStatus httpStatus;
	private boolean success = false;
	
//	Gettera and Setters
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
//	Using Field Constructor
	public CustomResponse(String message, HttpStatus httpStatus, boolean success) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
		this.success = success;
	}
	
//	Without Using Field Constructor
	public CustomResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
	
}
