package com.training.employeemanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UpdateEmployeeRequest {
	
	
	private int id;
	
	
	private String firstName;
	
	
	private String lastName;
	

	private String email;
	
	
	private double mobile;

	private String departmentName;
	private String city;
}