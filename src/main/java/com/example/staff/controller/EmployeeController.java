package com.example.staff.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.staff.entity.dto.EmployeeRequest;
import com.example.staff.mapper.EmployeeRequestToEmployee;
import com.example.staff.model.Employee;
import com.example.staff.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EmployeeController {

	private final EmployeeService employeeService;
	private final EmployeeRequestToEmployee mapper;
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
		
			return new ResponseEntity<>(employeeService.getEmployeeById(id),HttpStatus.OK);
	}
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		
		try {
		return new ResponseEntity<>(employeeService.getAllEmployee(),HttpStatus.OK);
		} catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@PostMapping("/employee")
	public ResponseEntity<HttpStatus> addEmployee(@RequestBody EmployeeRequest employeeRequest){
		try {
			employeeService.addEmployee(mapper.employeeRequestToEmployee(employeeRequest));
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
}
