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

import com.example.staff.entity.EmployeeEntity;
import com.example.staff.service.EmployeeEntityService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EmployeeEntityController {

	private final EmployeeEntityService employeeEntityService;
	
	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeEntity> getEmployeeEntityById(@PathVariable Long id){
		try {
			return new ResponseEntity<>(employeeEntityService.getEmployeeEntityById(id),HttpStatus.OK);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@GetMapping("/employee")
	public ResponseEntity<List<EmployeeEntity>> getAllEmployee(){
		
		try {
		return new ResponseEntity<>(employeeEntityService.getAllEmployeeEntity(),HttpStatus.OK);
		} catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@PostMapping("/employee")
	public ResponseEntity<HttpStatus> addEmployeeEntity(@RequestBody EmployeeEntity employeeEntity){
		try {
			employeeEntityService.addEmployeeEntity(employeeEntity);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
}
