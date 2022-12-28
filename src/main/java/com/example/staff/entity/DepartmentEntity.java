package com.example.staff.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="division_id")
	private DivisionEntity division;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="group_id")
	private GroupeEntity groupe;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="function_group_id")
	private FunctionGroupEntity functionGroup;
	
}
