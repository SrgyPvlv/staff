package com.example.staff.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

	Long id;
	Division division;
	Groupe groupe;
	FunctionGroup function_group;
}
