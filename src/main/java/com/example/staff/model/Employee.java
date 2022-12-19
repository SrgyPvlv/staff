package com.example.staff.model;

import java.time.LocalDate;

import lombok.Value;

@Value
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
	Long fact_department;
	Long staff_department;
	Long car;
	Long position;
}
