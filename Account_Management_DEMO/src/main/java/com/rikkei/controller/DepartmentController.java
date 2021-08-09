package com.rikkei.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rikkei.dto.DepartmentDto;
import com.rikkei.entity.Department;
import com.rikkei.service.IDepartmentService;

@RestController
@RequestMapping(value = "api/v1/departments")
@CrossOrigin("*")
public class DepartmentController {
	@Autowired
	private IDepartmentService departmentService;

	@GetMapping()
	public ResponseEntity<?> getAllDepartments() {
		List<Department> listDep = departmentService.getAllDepartments();

		List<DepartmentDto> dtos = new ArrayList<>();

		// convert entities --> dtos
		for (Department entity : listDep) {
			DepartmentDto dto = new DepartmentDto(entity.getDepartmentID(), entity.getDepartmentName());
			dtos.add(dto);
		}

		return new ResponseEntity<List<DepartmentDto>>(dtos, HttpStatus.OK);
	}

//	@GetMapping()
//	public ResponseEntity<?> getAllDepartments(Pageable pageable) {
//		Page<Department> entities = departmentService.getAllDepartments(pageable);
//		Page<DepartmentDto> dtoPage = entities.map(new Function<Department, DepartmentDto>() {
//			@Override
//			public DepartmentDto apply(Department department) {
//				DepartmentDto dto = new DepartmentDto(department.getDepartmentID(), department.getDepartmentName());
//				return dto;
//			}
//		});
//		return new ResponseEntity<Page<DepartmentDto>>(dtoPage, HttpStatus.OK);
//	}

	@GetMapping(value = "/{departmentID}")
	public ResponseEntity<?> getDepartmentByID(@PathVariable(name = "departmentID") short departmentID) {
		return new ResponseEntity<Department>(departmentService.getDepartmentByID(departmentID), HttpStatus.OK);
	}

	@GetMapping(value = "/departmentName/{departmentName}")
	public ResponseEntity<?> getDepartmentByName(@PathVariable(name = "departmentName") String departmentName) {
		return new ResponseEntity<Department>(departmentService.getDepartmentByName(departmentName), HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<?> createDepartment(Department department) {
		departmentService.createDepartment(department);
		return new ResponseEntity<String>("Create success", HttpStatus.CREATED);
	};

	@PutMapping(value = "/{departmentID}")
	public ResponseEntity<?> updateDepartment(@PathVariable(name = "departmentID") short departmentID,
			Department department) {
		department.setDepartmentID(departmentID);
		departmentService.updateDepartment(department);
		return new ResponseEntity<String>("Update success", HttpStatus.OK);
	}

	@DeleteMapping(value = "/{departmentID}")
	public ResponseEntity<?> deleteDepartment(@PathVariable(name = "departmentID") short departmentID) {
		departmentService.deleteDepartment(departmentID);
		return new ResponseEntity<String>("Delete success", HttpStatus.OK);
	}
}
