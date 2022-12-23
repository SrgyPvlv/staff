package com.example.staff.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.staff.entity.EmployeeEntity;

@Service
public interface EmployeeEntityService {
	
	EmployeeEntity getEmployeeEntityById(Long id);
	List<EmployeeEntity> getAllEmployeeEntity();
	void addEmployeeEntity(EmployeeEntity employee);
}
