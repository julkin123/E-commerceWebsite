package com.ecommerce.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ReviewNotFoundException extends RuntimeException{

	public ReviewNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
