package com.training.employeemanagementsystem.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

import com.training.employeemanagementsystem.dto.CreateEmployeeRequest;
import com.training.employeemanagementsystem.dto.EmployeeDetails;
import com.training.employeemanagementsystem.dto.UpdateEmployeeRequest;


@Validated
public interface IEmployeeService {

	
	public EmployeeDetails addEmployee(@Valid CreateEmployeeRequest request);
	public EmployeeDetails updateEmployee(@Valid UpdateEmployeeRequest update);
	public List<EmployeeDetails> findAllEmployee();
	public EmployeeDetails findEmployeeById(@Min(1) int id);
	public void deleteEmployee(@Min(1) int id);
	
}
