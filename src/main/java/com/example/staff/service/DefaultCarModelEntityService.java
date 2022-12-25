package com.example.staff.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.staff.entity.CarModelEntity;
import com.example.staff.exception.EmployeeNotFoundException;
import com.example.staff.repository.CarModelRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DefaultCarModelEntityService implements  CarModelEntityService{
	private final CarModelRepository carModelRepository;
	
	@Override
	public CarModelEntity getCarModelEntityById(Long id) {
		CarModelEntity carModelEntity=carModelRepository
				.findById(id)
				.orElseThrow(()->new EmployeeNotFoundException("Employee not found: id = " + id));
		return carModelEntity;
	}

	@Override
	public List<CarModelEntity> getAllCarModelEntity() {
		
		List<CarModelEntity> carmodels=carModelRepository.findAll();
		return carmodels;
	}

	@Override
	public void addCarModelEntity(CarModelEntity carModelEntity) {
		carModelRepository.saveAndFlush(carModelEntity);
		
	}

	@Override
	public void editCarModelEntity(Long id, CarModelEntity carModelEntity) {
		CarModelEntity editedCarModelEntity=carModelRepository
				.findById(id)
				.orElseThrow(()->new EmployeeNotFoundException("Employee not found: id = " + id));
		editedCarModelEntity.setCar_model(carModelEntity.getCar_model());
		carModelRepository.saveAndFlush(editedCarModelEntity);
	}

	@Override
	public void deleteCarModelEntityById(Long id) {
		carModelRepository.deleteById(id);
		
	}

}
