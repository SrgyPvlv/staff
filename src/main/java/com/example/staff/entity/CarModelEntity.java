package com.example.staff.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="carmodels")
public class CarModelEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String car_model;
	
	@OneToMany(mappedBy="carmodel",cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=false)
	private List<CarEntity> cars=new ArrayList<>();
	
	public void addCarEntity(CarEntity carEntity) {
		cars.add(carEntity);
		carEntity.setCarmodel(this);
	}
	
	public void removeCarEntity(CarEntity carEntity) {
		cars.remove(carEntity);
		carEntity.setCarmodel(null);
	}
}
