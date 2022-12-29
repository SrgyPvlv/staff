package com.example.staff.service;

import java.util.List;

import com.example.staff.entity.PositionEntity;

public interface PositionEntityService {

	PositionEntity getPositionEntityById(Long id);
	List<PositionEntity> getAllPositionEntity();
	void addPositionEntity(PositionEntity positionEntity);
	void editPositionEntity(Long id,PositionEntity positionEntity);
	void deletePositionEntityById(Long id);
	
}
