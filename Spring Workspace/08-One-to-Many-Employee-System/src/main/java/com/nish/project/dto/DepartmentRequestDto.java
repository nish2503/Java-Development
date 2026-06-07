package com.nish.project.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DepartmentRequestDto {

	@NotBlank(message="Department name required")
	@JsonProperty("department_name")
	private String departmentName;

	@NotBlank(message="Location required")
	private String location;

	@Valid
	@NotEmpty(message="Employees required")
	private List<EmployeeRequestDto> employees;
}