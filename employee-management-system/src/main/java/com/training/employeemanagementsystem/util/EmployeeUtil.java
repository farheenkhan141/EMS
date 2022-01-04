package com.training.employeemanagementsystem.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.hibernate.mapping.Set;
import org.springframework.stereotype.Component;

import com.training.employeemanagementsystem.constant.Gender;
import com.training.employeemanagementsystem.dto.CreateEmployeeRequest;
import com.training.employeemanagementsystem.dto.EmployeeDetails;
import com.training.employeemanagementsystem.dto.UpdateEmployeeRequest;
import com.training.employeemanagementsystem.model.Department;
import com.training.employeemanagementsystem.model.Employee;

@Component
public class EmployeeUtil {

	public EmployeeDetails toDetails(Employee employee) {
		EmployeeDetails details = new EmployeeDetails();
		details.setEmail(employee.getEmail());
		details.setFirstName(employee.getFirstName());
		details.setLastName(employee.getLastName());
		details.setId(employee.getId());
		details.setCity(employee.getCity());
		details.setMobile(employee.getMobile());
		Department dept=employee.getDepartment();
		details.setDepartmentName(dept.getDepartmentName());
		details.setGender(employee.getGender().toString());		
		return details;
	}

	public List<EmployeeDetails> toDetailsList(Collection<Employee> employees) {
		List<EmployeeDetails> detailsList = new ArrayList<>();
		EmployeeDetails details;
		for (Employee employee : employees) {
			details = toDetails(employee);
			detailsList.add(details);
		}
		return detailsList;

	}

	public Employee requestToEmployee(CreateEmployeeRequest request) {
		
		Employee employee = new Employee();
		employee.setEmail(request.getEmail());
		employee.setFirstName(request.getFirstName());
		employee.setLastName(request.getLastName());
		employee.setMobile(request.getMobile());
		employee.setGender(Gender.toEnum(request.getGender()));
		employee.setCity(request.getCity());

		return employee;

	}

	public Employee updateToEmployee(UpdateEmployeeRequest request,Employee employee) {
		
	if(request.getFirstName().isEmpty()==false) {
		employee.setFirstName(request.getFirstName());
	}
	if(request.getLastName().isEmpty()==false) {
		employee.setLastName(request.getLastName());
	}
	if(request.getCity().isEmpty()==false) {
		employee.setCity(request.getCity());
	}
	if(request.getEmail().isEmpty()==false) {
		employee.setEmail(request.getEmail());
	}
	if(request.getMobile()!=0) {
		employee.setMobile(request.getMobile());
	}
	
		
		return employee;
	}

}
