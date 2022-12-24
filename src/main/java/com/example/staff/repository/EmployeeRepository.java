package com.example.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.staff.entity.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

}
