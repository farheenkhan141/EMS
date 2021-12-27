package com.training.employeemanagementsystem.dto;

import java.util.List;




import lombok.Data;
import lombok.Getter;



@Data
@Getter
public class CreateEmployeeRequest {



	private String firstName;

	private String lastName;

	private String email;

	private String city;
	private double mobile;
	
	private String departmentName;
}
