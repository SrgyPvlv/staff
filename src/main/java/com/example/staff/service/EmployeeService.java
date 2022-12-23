package com.example.staff.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.staff.model.Employee;

@Service
public interface EmployeeService {
	
	Employee getEmployeeById(Long id);
	List<Employee> getAllEmployee();
	void addEmployee(Employee employee);
}
