package com.example.staff.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.staff.entity.CarEntity;
import com.example.staff.exception.EmployeeNotFoundException;
import com.example.staff.repository.CarRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultCarEntityService implements CarEntityService {
	
	private final CarRepository carRepository;
	
	@Override
	public CarEntity getCarEntityById(Long id) {
		CarEntity carEntity=carRepository
				.findById(id)
				.orElseThrow(()-> new EmployeeNotFoundException("Employee not found: id = " + id));
		return carEntity;
	}

	@Override
	public List<CarEntity> getAllCarEntity() {
		List<CarEntity> cars=carRepository.findAll();
		return cars;
	}

	@Override
	public void addCarEntity(CarEntity carEntity) {
		carRepository.saveAndFlush(carEntity);
		
	}

	@Override
	public void editCarEntity(Long id, CarEntity carEntity) {
		CarEntity editedCarEntity=carRepository
				.findById(id)
				.orElseThrow(()-> new EmployeeNotFoundException("Employee not found: id = " + id));
		editedCarEntity.setCar_number(carEntity.getCar_number());
		editedCarEntity.setCar_comment(carEntity.getCar_comment());
		editedCarEntity.setCarmodel(carEntity.getCarmodel());
		
		carRepository.saveAndFlush(editedCarEntity);
	}

	@Override
	public void deleteCarEntityById(Long id) {
		carRepository.deleteById(id);
		
	}

	
}
