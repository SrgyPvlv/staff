package com.example.staff.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EmployeeRequest {

	private String name;
	private String mobile_phone;
	private LocalDate birthday;
	private Integer local_phone;
	private Integer employee_id;
	private String login;
	private String email;
	private String employee_comment;
	private Long fact_department;
	private Long staff_department;
	private Long car;
	private Long position;
}
