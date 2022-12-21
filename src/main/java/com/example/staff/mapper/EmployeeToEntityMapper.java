package com.example.staff.mapper;

import org.mapstruct.Mapper;

import com.example.staff.entity.EmployeeEntity;
import com.example.staff.model.Employee;

@Mapper(componentModel="spring")
public interface EmployeeToEntityMapper {

	EmployeeEntity employeeToEmployeeEntity(Employee employee);
	Employee employeeEntityToEmployee(EmployeeEntity employeeEntity);
}
