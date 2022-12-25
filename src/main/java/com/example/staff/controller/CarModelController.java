package com.example.staff.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.staff.entity.CarModelEntity;
import com.example.staff.service.CarModelEntityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CarModelController {

	private final CarModelEntityService carModelEntityService;
	
	@GetMapping("/carmodel/{id}")
	public ResponseEntity<CarModelEntity> getCarModelEntityById(@PathVariable Long id){
		try {
			return new ResponseEntity<>(carModelEntityService.getCarModelEntityById(id), HttpStatus.OK);
		}catch (Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@GetMapping("/carmodel")
	public ResponseEntity<List<CarModelEntity>> getAllCarModelEntity(){
		try {
			return new ResponseEntity<>(carModelEntityService.getAllCarModelEntity(), HttpStatus.OK);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@PostMapping("/carmodel")
	public ResponseEntity<HttpStatus> addCarModelEntity(@RequestBody CarModelEntity carModelEntity){
		try {
			carModelEntityService.addCarModelEntity(carModelEntity);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@PutMapping("/carmodel/{id}")
	public ResponseEntity<HttpStatus> editCarModelEntity(@PathVariable Long id, @RequestBody CarModelEntity carModelEntity){
		try {
			carModelEntityService.editCarModelEntity(id, carModelEntity);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);}
	}
	
	@DeleteMapping("/carmodel/{id}")
	public ResponseEntity<HttpStatus> deleteCarModelEntityById(@PathVariable Long id){
		try {
			carModelEntityService.deleteCarModelEntityById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
}
