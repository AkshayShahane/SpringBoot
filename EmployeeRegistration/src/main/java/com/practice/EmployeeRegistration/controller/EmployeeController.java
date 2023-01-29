package com.practice.EmployeeRegistration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.EmployeeRegistration.model.Employee;
import com.practice.EmployeeRegistration.service.EmployeeServiceImpl;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	//create
	@PostMapping(value="/create")
	public Employee createEmployeeRegistration(@RequestBody Employee emp) {
		return employeeServiceImpl.createEmployeeRegistration(emp);
	}
	//getEmployeeById
	@GetMapping(value="/{id}")
	public Employee getEmployeeById(@PathVariable(name="id") Long id) {
		return employeeServiceImpl.getEmployeeById(id);
	}
	//getEmployees
	@GetMapping(value="/all")
	public Iterable<Employee> getEmployees() {
		return employeeServiceImpl.getEmployees();
	}
	//updateEmployeeInfo
	@PutMapping(value="/{id}")
	public String updateEmployeeInfo(@PathVariable(value="id") Long id,
									 @RequestBody Employee e) {
		return employeeServiceImpl.updateEmployeeInfo(id, e);
	}
	//deleteEmployee
	@DeleteMapping(value="/{id}")
	public String deleteEmployeeById(@PathVariable(name="id") Long id) {
		return employeeServiceImpl.deleteEmployeeById(id);
	}
}
