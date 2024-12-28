package com.ecommerce.Exception;

import java.util.Date;

public class ApiError {
	private int errorCode;
	private String message;
	private Date date;
	public ApiError(int errorCode, String message, Date date) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.date = date;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
