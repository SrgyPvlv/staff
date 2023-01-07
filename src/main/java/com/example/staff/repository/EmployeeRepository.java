package com.example.staff.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.staff.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
	
	List<EmployeeEntity> findByNameIgnoreCaseContainingOrderByNameAsc(@Param("filter") String filter);
	
	List<EmployeeEntity> findByMobilePhoneContainingOrderByNameAsc(@Param("filter") String filter);
	
	List<EmployeeEntity> findByPositionPositionIgnoreCaseContainingOrderByNameAsc(@Param("filter") String filter);
	
}
