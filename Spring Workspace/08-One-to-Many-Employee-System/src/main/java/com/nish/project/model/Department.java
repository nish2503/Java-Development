package com.nish.project.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="departments")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Department {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(nullable=false,unique=true)
	private String departmentName;

	@Column(nullable=false)
	private String location;

	@OneToMany(mappedBy="department",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Employee> employees;
}