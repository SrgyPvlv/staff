package com.example.staff.entity;

import java.util.ArrayList;
import java.util.List;

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
@Table(name="departments")
public class DepartmentEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String fact_division;
	private String fact_group;
	private String fact_function_group;
	private String staff_division;
	private String staff_group;
	private String staff_function_group;
	
	@OneToMany(mappedBy="department",fetch=FetchType.EAGER,orphanRemoval=false)
	private List<EmployeeEntity> employees=new ArrayList<>(); 
}
