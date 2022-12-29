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

import com.example.staff.entity.PositionEntity;
import com.example.staff.service.PositionEntityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PositionEntityController {

	private final PositionEntityService positionEntityService;
	
	@GetMapping("/positions/{id}")
	public ResponseEntity<PositionEntity> getPositionById(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(positionEntityService.getPositionEntityById(id));
		}catch (Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@GetMapping("/positions")
	public ResponseEntity<List<PositionEntity>> getAllPositionEntity(){
		try {
			return ResponseEntity.ok(positionEntityService.getAllPositionEntity());
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_FOUND);}
	}
	
	@PostMapping("/positions")
	public ResponseEntity<HttpStatus> addPositionEntity(@RequestBody PositionEntity positionEntity){
		try {
			positionEntityService.addPositionEntity(positionEntity);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
	
	@PutMapping("/positions/{id}")
	public ResponseEntity<HttpStatus> editPositionEntity(@PathVariable Long id,@RequestBody PositionEntity positionEntity){
		try {
			positionEntityService.editPositionEntity(id, positionEntity);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);}
	}
	
	@DeleteMapping("/positions/{id}")
	public ResponseEntity<HttpStatus> deletePositionEntityById(@PathVariable Long id){
		try {
			positionEntityService.deletePositionEntityById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception ex) {return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);}
	}
}
