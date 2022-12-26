package com.example.staff.service;

import java.util.List;

import com.example.staff.entity.CarEntity;

public interface CarEntityService {

	CarEntity getCarEntityById(Long ig);
	List<CarEntity> getAllCarEntity();
	void addCarEntity(CarEntity carEntity);
	void editCarEntity(Long id, CarEntity carEntity);
	void deleteCarEntityById(Long id);
}
