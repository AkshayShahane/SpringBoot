package com.practice.EmployeeRegistration.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.practice.EmployeeRegistration.model.Employee;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Long>{

}
