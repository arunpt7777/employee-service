package com.motta.employee_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.motta.employee_service.model.EmployeeDTO;
import com.motta.employee_service.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	// create Employee REST API
	@PostMapping("/employees")
	public ResponseEntity<EmployeeDTO> createUser(@RequestBody EmployeeDTO employeeDTO) {
		EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}

	// Retrieve Employee by id REST API
	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeDTO> retrieveEmployeeById(@PathVariable("id") Integer id) {
		EmployeeDTO employee = employeeService.retrieveEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	// Retrieve All Employees REST API
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
		List<EmployeeDTO> employees = employeeService.getAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	// Update Employee REST API
	@PutMapping("/employees/{id}")
	public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Integer id,
			@RequestBody EmployeeDTO employee) {
		employee.setId(id);
		EmployeeDTO updatedEmployee = employeeService.updateEmployee(employee);
		return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	}

	// Delete Employee REST API
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Integer id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>("Employee successfully deleted!", HttpStatus.OK);
	}
}
