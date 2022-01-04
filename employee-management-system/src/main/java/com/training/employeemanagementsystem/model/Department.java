package com.training.employeemanagementsystem.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Department {

	@GeneratedValue
	@Id
	private int deptId;

	@NotNull
	private String departmentName;


	 @OneToMany(targetEntity=Employee.class,mappedBy="department",fetch=FetchType.EAGER) 
	 private List<Employee> employees;
	 

}
