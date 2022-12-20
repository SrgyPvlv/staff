package com.example.staff.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.staff.entity.CarEntity;

public interface CarRepository extends JpaRepository<CarEntity,Long> {

}
