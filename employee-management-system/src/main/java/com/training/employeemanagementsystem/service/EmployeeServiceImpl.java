package com.training.employeemanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.training.employeemanagementsystem.dto.CreateEmployeeRequest;
import com.training.employeemanagementsystem.dto.EmployeeDetails;
import com.training.employeemanagementsystem.dto.UpdateEmployeeRequest;
import com.training.employeemanagementsystem.exceptions.EmployeeNotFoundException;
import com.training.employeemanagementsystem.model.Department;
import com.training.employeemanagementsystem.model.Employee;
import com.training.employeemanagementsystem.repository.IEmployeeRepository;
import com.training.employeemanagementsystem.util.EmployeeUtil;

@Transactional
@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeRepository repo;

	@Autowired
	private EmployeeUtil empUtil;

	@Override
	public EmployeeDetails addEmployee(CreateEmployeeRequest request) {
		Employee employee;
		Department dept=new Department();
		dept.setDepartmentName(request.getDepartmentName());
		employee= empUtil.requestToEmployee(request);
		employee.setDepartment(dept);
		EmployeeDetails details = empUtil.toDetails(repo.save(employee));
		return details;
	}

	@Override
	public EmployeeDetails updateEmployee(UpdateEmployeeRequest update) {
		Employee employee;
		boolean exist=repo.existsById(update.getId());
		if(exist==true) {
			employee=repo.getById(update.getId());
		}else {
			employee=new Employee();
		}
		
		employee=empUtil.updateToEmployee(update,employee);
	
		EmployeeDetails details=empUtil.toDetails(repo.save(employee));
		return details;
	}

	@Override
	public List<EmployeeDetails> findAllEmployee() {
		List<EmployeeDetails> empList = empUtil.toDetailsList(repo.findAll());
		return empList;
	}

	@Override
	public EmployeeDetails findEmployeeById(int id) {
		Optional<Employee> employee = repo.findById(id);
		if(!employee.isPresent()) {
			throw new EmployeeNotFoundException("No such employee is in db with this id :"+id);
		}
		
		EmployeeDetails details = empUtil.toDetails(employee.get());
		return details;
	}

	@Override
	public void deleteEmployee(int id) {
		Optional<Employee> employee = repo.findById(id);
		if(!employee.isPresent()) {
			throw new EmployeeNotFoundException("No such employee is in db with this id :"+id);
		}
		repo.delete(employee.get());
	}

}
