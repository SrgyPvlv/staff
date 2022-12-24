package com.example.staff.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

	Long id;
	String car_number;
	String car_comment;
	CarModel carmodel;
	Employee employee;
}
