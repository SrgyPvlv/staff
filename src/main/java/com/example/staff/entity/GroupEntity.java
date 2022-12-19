package com.example.staff.entity;

import java.util.ArrayList;
import java.util.List;

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
@Table(name="groups")
public class GroupEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String group;
	
	@OneToMany(mappedBy="group",fetch=FetchType.EAGER,orphanRemoval=false)
	private List<DepartmentEntity> departments=new ArrayList<>();
	
	public void addDepartmentEntity(DepartmentEntity departmentEntity) {
		departments.add(departmentEntity);
		departmentEntity.setGroup(this);
	}
	
	public void removeDepartmentEntity(DepartmentEntity departmentEntity) {
		departments.remove(departmentEntity);
		departmentEntity.setGroup(null);
	}
}
