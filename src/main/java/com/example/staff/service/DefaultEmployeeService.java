package com.example.staff.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.staff.entity.EmployeeEntity;
import com.example.staff.exception.EmployeeNotFoundException;
import com.example.staff.mapper.EmployeeToEntityMapper;
import com.example.staff.model.Employee;
import com.example.staff.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultEmployeeService implements EmployeeService {
	private final EmployeeRepository employeeRepository;
	private final EmployeeToEntityMapper mapper;
	
	@Override
	public Employee getEmployeeById(Long id) {	
		EmployeeEntity employeeEntity=employeeRepository
				.findById(id)
				.orElseThrow(()->new EmployeeNotFoundException("Employee not found: id = " + id));
		return mapper.employeeEntityToEmployee(employeeEntity);
	}

	@Override
	public List<Employee> getAllEmployee() {
		Iterable<EmployeeEntity> iterable=employeeRepository.findAll();
		ArrayList<Employee> employees=new ArrayList<>();
		for(EmployeeEntity employeeEntity: iterable) {
			employees.add(mapper.employeeEntityToEmployee(employeeEntity));
		}
		return employees;
	}

	@Override
	public void addEmployee(Employee employee) {
		employeeRepository.saveAndFlush(mapper.employeeToEmployeeEntity(employee));
		
	}

}
