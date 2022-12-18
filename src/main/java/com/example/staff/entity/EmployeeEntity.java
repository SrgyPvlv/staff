package com.example.staff.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
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
@Table(name="employees")
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String mobile_phone;
	private LocalDate birthday;
	private Integer local_phone;
	private Integer employee_id;
	private String login;
	private String email;
	private String employee_comment;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="departments_id")
	private DepartmentEntity department;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="cars_id")
	private CarEntity car;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="positions_id")
	private PositionEntity position;
}
