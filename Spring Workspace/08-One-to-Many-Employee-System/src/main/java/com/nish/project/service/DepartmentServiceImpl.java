package com.nish.project.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nish.project.dto.DepartmentRequestDto;
import com.nish.project.dto.DepartmentResponseDto;
import com.nish.project.dto.PageResponseDto;
import com.nish.project.exception.DuplicateResourceException;
import com.nish.project.exception.ResourceNotFoundException;
import com.nish.project.model.Department;
import com.nish.project.model.Employee;
import com.nish.project.repository.DepartmentRepository;
import com.nish.project.repository.EmployeeRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository departmentRepository;

	private EmployeeRepository employeeRepository;

	private ModelMapper mapper;

	private Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	public DepartmentServiceImpl(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository,
			ModelMapper mapper) {

		this.departmentRepository = departmentRepository;
		this.employeeRepository = employeeRepository;
		this.mapper = mapper;
	}

	@Override
	public DepartmentResponseDto createDepartment(DepartmentRequestDto departmentRequestDto) {

		logger.info("Creating department");

		if (departmentRepository.existsByDepartmentName(departmentRequestDto.getDepartmentName())) {

			throw new DuplicateResourceException("Department already exists");
		}

		validateEmployeeEmailsForCreate(departmentRequestDto);

		Department department = mapper.map(departmentRequestDto, Department.class);

		attachEmployeesToDepartment(department);

		Department savedDepartment = departmentRepository.save(department);

		return mapper.map(savedDepartment, DepartmentResponseDto.class);
	}

	@Override
	public List<DepartmentResponseDto> getAllDepartments() {

		logger.info("Fetching departments");

		return departmentRepository.findAll().stream()
				.map(department -> mapper.map(department, DepartmentResponseDto.class)).toList();
	}

	@Override
	public PageResponseDto<DepartmentResponseDto> getAllDepartmentsWithPagination(int pageNumber, int pageSize) {

		validatePagination(pageNumber, pageSize);

		Page<Department> page = departmentRepository.findAll(PageRequest.of(pageNumber, pageSize));

		List<DepartmentResponseDto> list = page.getContent().stream()
				.map(department -> mapper.map(department, DepartmentResponseDto.class)).toList();

		PageResponseDto<DepartmentResponseDto> response = new PageResponseDto<>();

		response.setContent(list);
		response.setPageNumber(page.getNumber());
		response.setPageSize(page.getSize());
		response.setTotalElements(page.getTotalElements());
		response.setTotalPages(page.getTotalPages());
		response.setLastPage(page.isLast());

		return response;
	}

	@Override
	public DepartmentResponseDto getDepartmentById(Long id) {

		Department department = findDepartmentById(id);

		return mapper.map(department, DepartmentResponseDto.class);
	}

	@Override
	public DepartmentResponseDto updateDepartment(Long id, DepartmentRequestDto departmentRequestDto) {

		Department department = findDepartmentById(id);

		if (departmentRepository.existsByDepartmentNameAndIdNot(departmentRequestDto.getDepartmentName(), id)) {

			throw new DuplicateResourceException("Department name already exists");
		}

		validateEmployeeEmailsForUpdate(departmentRequestDto, department);

		department.setDepartmentName(departmentRequestDto.getDepartmentName());

		department.setLocation(departmentRequestDto.getLocation());

		List<Employee> employees = departmentRequestDto.getEmployees().stream()
				.map(employeeDto -> mapper.map(employeeDto, Employee.class)).toList();

		department.getEmployees().clear();

		department.getEmployees().addAll(employees);

		attachEmployeesToDepartment(department);

		Department updatedDepartment = departmentRepository.save(department);

		return mapper.map(updatedDepartment, DepartmentResponseDto.class);
	}

	@Override
	public void deleteDepartment(Long id) {

		Department department = findDepartmentById(id);

		departmentRepository.delete(department);

		logger.info("Department deleted");
	}

	private Department findDepartmentById(Long id) {

		return departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department not found"));
	}

	private void attachEmployeesToDepartment(Department department) {

		department.getEmployees().forEach(employee -> employee.setDepartment(department));
	}

	private void validateEmployeeEmailsForCreate(DepartmentRequestDto dto) {

		dto.getEmployees().forEach(employee -> {

			if (employeeRepository.existsByEmail(employee.getEmail())) {

				throw new DuplicateResourceException("Employee email exists");
			}
		});
	}

	private void validateEmployeeEmailsForUpdate(DepartmentRequestDto dto, Department department) {

		dto.getEmployees().forEach(employee -> {

			boolean sameDepartment = department.getEmployees().stream()
					.anyMatch(e -> e.getEmail().equals(employee.getEmail()));

			if (!sameDepartment && employeeRepository.existsByEmail(employee.getEmail())) {

				throw new DuplicateResourceException("Employee email exists");
			}
		});
	}

	private void validatePagination(int pageNumber, int pageSize) {

		if (pageNumber < 0) {

			throw new IllegalArgumentException("Page number invalid");
		}

		if (pageSize <= 0 || pageSize > 100) {

			throw new IllegalArgumentException("Page size invalid");
		}
	}
}