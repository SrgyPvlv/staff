package com.example.staff.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FunctionGroup {

	Long id;
	String function_group;
	ArrayList<Department> departments;
}
