package com.example.staff.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarModel {

	Long id;
	String car_model;
	ArrayList<Car> cars;
}
