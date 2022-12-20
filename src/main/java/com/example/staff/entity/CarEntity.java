package com.example.staff.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cars")
public class CarEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String car_number;
	private String car_comment;
	
	@ManyToOne
	@JoinColumn(name="carmodels_id")
	private CarModelEntity carmodel;
	
	@OneToOne(mappedBy="car",fetch=FetchType.EAGER,orphanRemoval=false)
	private EmployeeEntity employee;
}
