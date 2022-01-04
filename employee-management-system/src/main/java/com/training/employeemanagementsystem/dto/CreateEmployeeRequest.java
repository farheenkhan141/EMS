package com.training.employeemanagementsystem.dto;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.Getter;




@Data
@Getter
public class CreateEmployeeRequest {


	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@NotBlank
	private String email;
	@NotBlank
	private String city;
	
	private double mobile;
	@NotBlank
	private String gender;
	@NotBlank
	private String departmentName;
}
