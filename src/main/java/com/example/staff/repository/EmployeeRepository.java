package com.example.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.staff.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
	
	List<EmployeeEntity> findByNameIgnoreCaseContaining(@Param("filter") String filter);
	
	List<EmployeeEntity> findByMobilePhoneContaining(@Param("filter") String filter);
	
	List<EmployeeEntity> findByPositionPositionIgnoreCaseContaining(@Param("filter") String filter);
	
}
