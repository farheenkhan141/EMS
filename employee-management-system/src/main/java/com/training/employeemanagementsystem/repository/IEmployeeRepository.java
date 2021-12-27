package com.training.employeemanagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.training.employeemanagementsystem.model.Employee;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{
	
	
	


}
