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
	public void addEmployeeEntity(EmployeeEntity employeeEntity) {
		employeeRepository.saveAndFlush(employeeEntity);
		
	}

	@Override
	public void editEmployeeEntity(Long id, EmployeeEntity employeeEntity) {
		EmployeeEntity editedEmployeeEntity=employeeRepository
				.findById(id)
				.orElseThrow(()->new EmployeeNotFoundException("Employee not found: id = " + id));
		editedEmployeeEntity.setName(employeeEntity.getName());
		editedEmployeeEntity.setMobilePhone(employeeEntity.getMobilePhone());
		editedEmployeeEntity.setBirthday(employeeEntity.getBirthday());
		editedEmployeeEntity.setLocalPhone(employeeEntity.getLocalPhone());
		editedEmployeeEntity.setEmployeeComment(employeeEntity.getEmployeeComment());
		editedEmployeeEntity.setLogin(employeeEntity.getLogin());
		editedEmployeeEntity.setEmail(employeeEntity.getEmail());
		editedEmployeeEntity.setEmployeeComment(employeeEntity.getEmployeeComment());
		editedEmployeeEntity.setFactDepartment(employeeEntity.getFactDepartment());
		editedEmployeeEntity.setFactDepartment(employeeEntity.getFactDepartment());
		editedEmployeeEntity.setCar(employeeEntity.getCar());
		editedEmployeeEntity.setPosition(employeeEntity.getPosition());
		
		employeeRepository.saveAndFlush(editedEmployeeEntity);
	}

	@Override
	public void deleteEmployEntityById(Long id) {
		employeeRepository.deleteById(id);
		
	}

}
