package com.training.employeemanagementsystem.service;

import java.util.List;

import com.training.employeemanagementsystem.dto.CreateEmployeeRequest;
import com.training.employeemanagementsystem.dto.EmployeeDetails;
import com.training.employeemanagementsystem.dto.UpdateEmployeeRequest;
import com.training.employeemanagementsystem.model.Employee;

public interface IEmployeeService {

	
	public EmployeeDetails addEmployee(CreateEmployeeRequest request);
	public EmployeeDetails updateEmployee(UpdateEmployeeRequest update);
	public List<EmployeeDetails> findAllEmployee();
	public EmployeeDetails findEmployeeById(int id);
	public void deleteEmployee(int id);
	
}
