package com.nish.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nish.project.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

	boolean existsByEmail(String email);

	boolean existsByEmailAndIdNot(String email,Long id);
}