package com.ecommerce.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RestControllerAdvice
public class GlobalExceptionController {
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<ApiError> userNotFoud(){
		ApiError apiError=new ApiError(404, "user not exists ", new Date());
		return new ResponseEntity<ApiError>(apiError,HttpStatus.NOT_FOUND);
		
		
	}

	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<ApiError> productNotFound(){
		 ApiError apierror=new ApiError(404, "product is not exists", new Date());
		
		return new ResponseEntity<ApiError>(apierror,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = CategoryNotFoundException.class)
	public ResponseEntity<ApiError> categoryNotFound(){
		 ApiError apierror=new ApiError(404, "Category is not exists", new Date());
		
		return new ResponseEntity<ApiError>(apierror,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value =ReviewNotFoundException.class )
	public ResponseEntity<ApiError> reviewNotFound(){
		 ApiError apierror=new ApiError(404, "review is not exists", new Date());
		
		return new ResponseEntity<ApiError>(apierror,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value =CartNotFoundException.class )
	public ResponseEntity<ApiError> cartNotFound(){
		 ApiError apierror=new ApiError(404, "cart is not exists", new Date());
		
		return new ResponseEntity<ApiError>(apierror,HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value =UserAlreadyExistException.class )
	public ResponseEntity<ApiError> userAlreadyExist(){
		 ApiError apierror=new ApiError(409, "User is already exists with given email id", new Date());
		
		return new ResponseEntity<ApiError>(apierror,HttpStatus.NOT_FOUND);
	}
}
