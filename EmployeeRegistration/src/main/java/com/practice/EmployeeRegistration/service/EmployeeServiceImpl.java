package com.practice.EmployeeRegistration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.EmployeeRegistration.dao.EmployeeDao;
import com.practice.EmployeeRegistration.model.Employee;

@Service
public class EmployeeServiceImpl {

	@Autowired
	private EmployeeDao employeeDao;
	
	//createEmployee
	public Employee createEmployeeRegistration(Employee employee) {
		return employeeDao.save(employee);
	}
	//getEmployeeById
	public Employee getEmployeeById(Long id) {
		return employeeDao.findById(id).orElse(new Employee());
	}
	//getAllEmployee
	public Iterable<Employee> getEmployees() {
		return employeeDao.findAll();
	}
	//updateEmployeeInfo
	public String updateEmployeeInfo(Long id, Employee e) {
		Employee emp = employeeDao.findById(id).orElse(new Employee());
		if(emp!=null) {
			emp.setDesignation(e.getDesignation());
			emp.setAddress(e.getAddress());
			employeeDao.save(emp);
			return "Record updated Successfully...";
		}else {
			return "employee Id not found...";
		}
	}
	//deleteEmployeeById
	public String deleteEmployeeById(Long id) {
		 employeeDao.deleteById(id);
		 return "Record Deleted Successfully...";
	}
}
