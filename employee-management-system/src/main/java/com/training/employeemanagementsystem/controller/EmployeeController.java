package com.training.employeemanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.employeemanagementsystem.dto.CreateEmployeeRequest;
import com.training.employeemanagementsystem.dto.EmployeeDetails;
import com.training.employeemanagementsystem.dto.UpdateEmployeeRequest;
import com.training.employeemanagementsystem.model.Employee;
import com.training.employeemanagementsystem.service.EmployeeServiceImpl;

@RefreshScope
@RequestMapping("/employees")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl service;

	@GetMapping("/greeting")
	public void greeting() {
		System.out.println("greeting : hello");
	}

	@PostMapping("/add")
	public EmployeeDetails addEmployee(@RequestBody CreateEmployeeRequest request) {
		
		EmployeeDetails response = service.addEmployee(request);
		return response;
	}

	@PutMapping("/update")
	public EmployeeDetails updateEmployee(@RequestBody UpdateEmployeeRequest update) {
		EmployeeDetails response = service.updateEmployee(update);
		return response;
	}

	@GetMapping("/getAll")
	public List<EmployeeDetails> findAllEmployee() {
		
		List<EmployeeDetails> responseList = service.findAllEmployee();
		return responseList;
	}

	@GetMapping("/get/byId")
	public EmployeeDetails findEmployeeById(@RequestParam int id) {
		
		EmployeeDetails response = service.findEmployeeById(id);
		return response;
	}

	@DeleteMapping("/delete/byId")
	public String deleteEmployeeById(@RequestParam int id) {
		service.deleteEmployee(id);
		return "Employee Deleted";

	}

}
