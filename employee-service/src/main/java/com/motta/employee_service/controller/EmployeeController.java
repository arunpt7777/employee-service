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

	// get Employee by id REST API
	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeDTO> retrieveEmployeeById(@PathVariable("id") Integer id) {
		EmployeeDTO employee = employeeService.retrieveEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}

	// Build Get All Employees REST API
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
		List<EmployeeDTO> employees = employeeService.getAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
	}

	// Build Update Employee REST API
	@PutMapping("/employees/{id}")
	public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Integer id,
			@RequestBody EmployeeDTO employee) {
		employee.setId(id);
		EmployeeDTO updatedEmployee = employeeService.updateEmployee(employee);
		return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	}

	// Build Delete Employee REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Integer id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>("Employee successfully deleted!", HttpStatus.OK);
	}

	/*
	 * @GetMapping("/employees/{id}") public Employee
	 * retrieveEmployeeById(@PathVariable Integer id) { Employee employee =
	 * repository.findById(id).orElse(null); if (employee == null) throw new
	 * UserNotFoundException("No such employee found with id = " + id); return
	 * employee; }
	 * 
	 * @GetMapping("/employees") public List<Employee> retrieveAll() {
	 * List<Employee> allEmployees = repository.findAll(); if
	 * (allEmployees.isEmpty()) throw new
	 * UserNotFoundException("No employee records found"); return allEmployees; }
	 * 
	 * @PostMapping("/employees") public ResponseEntity<Employee>
	 * addEmployee(@RequestBody Employee emp) { emp.setId(++userCount); Employee
	 * savedEmployee = repository.save(emp); URI location =
	 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
	 * .buildAndExpand(savedEmployee.getId()).toUri(); return
	 * ResponseEntity.created(location).build(); }
	 * 
	 * @DeleteMapping("/employees/{id}") public void
	 * deleteEmployeeById(@PathVariable Integer id) { repository.deleteById(id); }
	 * 
	 * @PutMapping("/employees/{id}") public ResponseEntity<Employee>
	 * updateEmployee(@PathVariable Integer id, @RequestBody Employee emp) {
	 * Employee existingEmployee = repository.findById(id).get(); if
	 * (existingEmployee == null) throw new
	 * UserNotFoundException("No such employee found with id = " + id);
	 * 
	 * repository.deleteById(id); emp.setId(id); repository.save(emp); URI location
	 * = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
	 * .buildAndExpand(existingEmployee.getId()).toUri(); return
	 * ResponseEntity.created(location).build(); }
	 */
}
