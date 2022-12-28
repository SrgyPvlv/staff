package com.example.staff.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	private String carModel;
	
	@OneToMany(mappedBy="carModel",cascade=CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval=false)
	@JsonIgnore
	private List<CarEntity> cars=new ArrayList<>();
	
	public void addCarEntity(CarEntity carEntity) {
		cars.add(carEntity);
		carEntity.setCarModel(this);
	}
	
	public void removeCarEntity(CarEntity carEntity) {
		cars.remove(carEntity);
		carEntity.setCarModel(null);
	}
	
}
