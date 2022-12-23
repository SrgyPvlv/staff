package com.example.staff.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

	Long id;
	String name;
	String mobile_phone;
	LocalDate birthday;
	Integer local_phone;
	Integer employee_id;
	String login;
	String email;
	String employee_comment;
	Department fact_department;
	Department staff_department;
	Car car;
	Position position;
}
