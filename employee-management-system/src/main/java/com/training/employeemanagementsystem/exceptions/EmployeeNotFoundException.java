package com.training.employeemanagementsystem.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
	public  EmployeeNotFoundException(String msg) {
		super(msg);
		System.out.println(msg);
	}
	

}
