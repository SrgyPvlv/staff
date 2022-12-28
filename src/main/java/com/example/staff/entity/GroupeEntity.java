package com.example.staff.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name="groupes")
public class GroupeEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String groupe;
	
	@OneToMany(mappedBy="groupe",fetch=FetchType.LAZY,orphanRemoval=false)
	@JsonIgnore
	private List<DepartmentEntity> departments=new ArrayList<>();
	
	public void addDepartmentEntity(DepartmentEntity departmentEntity) {
		departments.add(departmentEntity);
		departmentEntity.setGroupe(this);
	}
	
	public void removeDepartmentEntity(DepartmentEntity departmentEntity) {
		departments.remove(departmentEntity);
		departmentEntity.setGroupe(null);
	}
}
