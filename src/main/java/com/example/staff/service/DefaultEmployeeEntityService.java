package com.example.staff.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.staff.entity.EmployeeEntity;
import com.example.staff.exception.EmployeeNotFoundException;
import com.example.staff.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultEmployeeEntityService implements EmployeeEntityService {
	private final EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeEntity getEmployeeEntityById(Long id) {	
		EmployeeEntity employee=employeeRepository
				.findById(id)
				.orElseThrow(()->new EmployeeNotFoundException("Employee not found: id = " + id));
		return employee;
	}

	@Override
	public List<EmployeeEntity> getAllEmployeeEntity() {
		List<EmployeeEntity> employees=employeeRepository.findAll();
		return employees;
	}

	@Override
	public void addEmployeeEntity(EmployeeEntity employee) {
		employeeRepository.saveAndFlush(employee);
		
	}

}