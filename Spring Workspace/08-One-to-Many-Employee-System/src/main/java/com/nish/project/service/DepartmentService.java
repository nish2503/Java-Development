package com.nish.project.service;

import java.util.List;

import com.nish.project.dto.DepartmentRequestDto;
import com.nish.project.dto.DepartmentResponseDto;
import com.nish.project.dto.PageResponseDto;

public interface DepartmentService {

	DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto);

	List<DepartmentResponseDto> getAllDepartments();

	PageResponseDto<DepartmentResponseDto> getAllDepartmentsWithPagination(int pageNumber,int pageSize);

	DepartmentResponseDto getDepartmentById(Long id);

	DepartmentResponseDto updateDepartment(Long id,DepartmentRequestDto departmentRequestDto);

	void deleteDepartment(Long id);
}