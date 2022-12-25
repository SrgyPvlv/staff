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
		editedEmployeeEntity.setMobile_phone(employeeEntity.getMobile_phone());
		editedEmployeeEntity.setBirthday(employeeEntity.getBirthday());
		editedEmployeeEntity.setLocal_phone(employeeEntity.getLocal_phone());
		editedEmployeeEntity.setEmployee_id(employeeEntity.getEmployee_id());
		editedEmployeeEntity.setLogin(employeeEntity.getLogin());
		editedEmployeeEntity.setEmail(employeeEntity.getEmail());
		editedEmployeeEntity.setEmployee_comment(employeeEntity.getEmployee_comment());
		editedEmployeeEntity.setFact_department(employeeEntity.getFact_department());
		editedEmployeeEntity.setStaff_department(employeeEntity.getStaff_department());
		editedEmployeeEntity.setCar(employeeEntity.getCar());
		editedEmployeeEntity.setPosition(employeeEntity.getPosition());
		
		employeeRepository.saveAndFlush(editedEmployeeEntity);
	}

	@Override
	public void deleteEmployEntityById(Long id) {
		employeeRepository.deleteById(id);
		
	}

}
