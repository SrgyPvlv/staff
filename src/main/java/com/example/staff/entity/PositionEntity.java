package com.example.staff.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name="positions")
public class PositionEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String position;
	
	
	@OneToMany(mappedBy="position",fetch=FetchType.LAZY,orphanRemoval=false)
	@JsonIgnore
	private List<EmployeeEntity> employees=new ArrayList<>();
	
	public void addEmployeeEntity(EmployeeEntity employeeEntity) {
		employees.add(employeeEntity);
		employeeEntity.setPosition(this);
	}
	
	public void removeEmployeeEntity(EmployeeEntity employeeEntity) {
		employees.remove(employeeEntity);
		employeeEntity.setPosition(null);
	}
	
}
