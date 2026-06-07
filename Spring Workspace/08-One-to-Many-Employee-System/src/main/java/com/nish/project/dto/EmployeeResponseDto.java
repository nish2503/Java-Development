package com.nish.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeResponseDto {

	private Long id;

	@JsonProperty("employee_name")
	private String employeeName;

	private String email;

	private Double salary;
}