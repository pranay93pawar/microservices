package com.pawar.demo.exception;

import java.util.Date;

public class ExceptionResponse {
	
	public Date timestamp;
	public String message;
	public String details;
	
	public ExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}	
}
