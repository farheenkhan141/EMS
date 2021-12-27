package com.training.employeemanagementsystem.exceptions;

public class InvalidIdException extends RuntimeException{
	public InvalidIdException(String msg) {
		super(msg);
		System.out.println(msg);
	}
	

}
