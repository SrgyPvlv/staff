package com.example.staff.service;

import java.util.List;

import com.example.staff.entity.EmployeeEntity;

public interface EmployeeEntityService {
	
	EmployeeEntity getEmployeeEntityById(Long id);
	List<EmployeeEntity> getAllEmployeeEntity();
	EmployeeEntity addEmployeeEntity(EmployeeEntity employeeEntity);
	EmployeeEntity editEmployeeEntity(Long id, EmployeeEntity employeeEntity);
	void deleteEmployEntityById(Long id);
}
