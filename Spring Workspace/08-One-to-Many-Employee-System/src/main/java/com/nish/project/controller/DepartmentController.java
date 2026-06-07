package com.nish.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nish.project.dto.DepartmentRequestDto;
import com.nish.project.dto.DepartmentResponseDto;
import com.nish.project.dto.PageResponseDto;
import com.nish.project.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

	private DepartmentService departmentService;

	private Logger logger=LoggerFactory.getLogger(DepartmentController.class);


	public DepartmentController(DepartmentService departmentService) {

		this.departmentService=departmentService;
	}


	@PostMapping
	public ResponseEntity<DepartmentResponseDto> createDepartment(@Valid @RequestBody DepartmentRequestDto departmentRequestDto){

		logger.info("Create department request received");

		return new ResponseEntity<>(departmentService.createDepartment(departmentRequestDto),HttpStatus.CREATED);
	}



	@GetMapping
	public ResponseEntity<List<DepartmentResponseDto>> getAllDepartments(){

		logger.info("Get departments request received");

		return ResponseEntity.ok(departmentService.getAllDepartments());
	}



	@GetMapping("/{id}")
	public ResponseEntity<DepartmentResponseDto> getDepartmentById(@PathVariable Long id){

		logger.info("Get department by id request received");

		return ResponseEntity.ok(departmentService.getDepartmentById(id));
	}



	@GetMapping("/page")
	public ResponseEntity<PageResponseDto<DepartmentResponseDto>> getAllDepartmentsWithPagination(
	@RequestParam(defaultValue="0") int pageNumber,
	@RequestParam(defaultValue="5") int pageSize){

		logger.info("Pagination request received");

		return ResponseEntity.ok(departmentService.getAllDepartmentsWithPagination(pageNumber,pageSize));
	}



	@PutMapping("/{id}")
	public ResponseEntity<DepartmentResponseDto> updateDepartment(@PathVariable Long id,@Valid @RequestBody DepartmentRequestDto departmentRequestDto){

		logger.info("Update department request received");

		return ResponseEntity.ok(departmentService.updateDepartment(id,departmentRequestDto));
	}



	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDepartment(@PathVariable Long id){

		logger.info("Delete department request received");

		departmentService.deleteDepartment(id);

		return ResponseEntity.noContent().build();
	}
}