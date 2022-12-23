package com.example.staff.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Groupe {

	Long id;
	String groupe;
	ArrayList<Department> departments;
}
