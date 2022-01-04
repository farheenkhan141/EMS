package com.training.employeemanagementsystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.training.employeemanagementsystem.exceptions.EmployeeNotFoundException;
import com.training.employeemanagementsystem.exceptions.InvalidIdException;

@RestControllerAdvice
public class CenteralizedExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidIdException.class)
	public String handleInvalidId(InvalidIdException e) {
		return e.getMessage();
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(EmployeeNotFoundException.class)
	public String handleMatchedtNotFound(EmployeeNotFoundException e) {
		return e.getMessage();
	}

}
