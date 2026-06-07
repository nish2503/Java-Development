package com.nish.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeRequestDto {

	@NotBlank(message="Employee name required")
	@JsonProperty("employee_name")
	private String employeeName;

	@NotBlank(message="Email required")
	@Email(message="Invalid email")
	private String email;

	@Positive(message="Salary should be greater than zero")
	private Double salary;
}