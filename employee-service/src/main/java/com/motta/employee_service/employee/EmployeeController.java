package com.motta.employee_service.employee;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.motta.employee_service.exception.UserNotFoundException;

@RestController
public class EmployeeController {

	private static int userCount = 0;

	@Autowired
	private EmployeeRepository repository;

	@GetMapping("/employees/{id}")
	public Employee retrieveEmployeeById(@PathVariable Integer id) {
		Employee employee = repository.findById(id).orElse(null);
		if (employee == null)
			throw new UserNotFoundException("No such employee found with id = " + id);
		return employee;
	}

	@GetMapping("/employees")
	public List<Employee> retrieveAll() {
		List<Employee> allEmployees = repository.findAll();
		if (allEmployees.isEmpty())
			throw new UserNotFoundException("No employee records found");
		return allEmployees;
	}

	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
		emp.setId(++userCount);
		Employee savedEmployee = repository.save(emp);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedEmployee.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/employees/{id}")
	public void deleteEmployeeById(@PathVariable Integer id) {
		repository.deleteById(id);
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee emp) {
		Employee existingEmployee = repository.findById(id).get();
		if (existingEmployee == null)
			throw new UserNotFoundException("No such employee found with id = " + id);

		repository.deleteById(id);
		emp.setId(id);
		repository.save(emp);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(existingEmployee.getId()).toUri();
		return ResponseEntity.created(location).build();
	}

}
