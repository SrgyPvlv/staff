package com.example.staff.service;

import java.util.List;

import com.example.staff.model.Employee;

public interface EmployeeService {
	
	Employee getEmployeeById(Long id);
	List<Employee> getAllEmployee();
	void addEmployee(Employee employee);
}
