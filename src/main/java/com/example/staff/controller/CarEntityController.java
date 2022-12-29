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

import com.example.staff.entity.CarEntity;
import com.example.staff.service.CarEntityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CarEntityController {

	private final CarEntityService carEntityService;
	
	@GetMapping("/cars/{id}")
	public ResponseEntity<CarEntity> getCarEntityById(@PathVariable Long id){
		try {
			return ResponseEntity.ok(carEntityService.getCarEntityById(id));
		} catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@GetMapping("/cars")
	public ResponseEntity<List<CarEntity>> getAllCarEntity(){
		try {
			return ResponseEntity.ok(carEntityService.getAllCarEntity());
		} catch (Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@PostMapping("/cars")
	public ResponseEntity<HttpStatus> addCarEntity(@RequestBody CarEntity carEntity){
		try {
			carEntityService.addCarEntity(carEntity);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@PutMapping("/cars/{id}")
	public ResponseEntity<HttpStatus> editCarEntity(@PathVariable Long id, @RequestBody CarEntity carEntity){
		try {
			carEntityService.editCarEntity(id, carEntity);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);}
	}
	
	@DeleteMapping("/cars/{id}")
	public ResponseEntity<HttpStatus> deleteCarEntityById(@PathVariable Long id){
		try {
			carEntityService.deleteCarEntityById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
}
