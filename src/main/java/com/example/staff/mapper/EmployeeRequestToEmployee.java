package com.example.staff.mapper;

import org.mapstruct.Mapper;

import com.example.staff.entity.dto.EmployeeRequest;
import com.example.staff.model.Employee;

@Mapper(componentModel="spring")
public interface EmployeeRequestToEmployee {
	
Employee employeeRequestToEmployee(EmployeeRequest employeeRequest);

}
