package com.example.staff.entity;

import java.time.LocalDate;

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
	
	@ManyToOne
	@JoinColumn(name="fact_departments_id")
	private DepartmentEntity fact_department;
	
	@ManyToOne
	@JoinColumn(name="staff_departments_id")
	private DepartmentEntity staff_department;
	
	@OneToOne
	@JoinColumn(name="cars_id")
	private CarEntity car;
	
	@ManyToOne
	@JoinColumn(name="positions_id")
	private PositionEntity position;
}
