package com.motta.employee_service.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motta.employee_service.entity.Employee;
import com.motta.employee_service.exception.EmployeeAlreadyExistsException;
import com.motta.employee_service.exception.EmployeeNotFoundException;
import com.motta.employee_service.mapper.EmployeeMapper;
import com.motta.employee_service.model.EmployeeDTO;
import com.motta.employee_service.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

		// CHeck if id already exists
		Optional<Employee> employee = repository.findById(employeeDTO.getId());
		if (employee.isPresent())
			throw new EmployeeAlreadyExistsException("Employee id = " + employeeDTO.getId() + " already Exists!");

		// Convert EmployeeDTO into User JPA Entity
		Employee newEmployee = EmployeeMapper.mapToEmployee(employeeDTO);
		Employee savedEmployee = repository.save(newEmployee);

		// Convert Employee JPA entity to UserDto
		EmployeeDTO savedEmployeeDTO = EmployeeMapper.mapToEmployeeDTO(savedEmployee);
		return savedEmployeeDTO;
	}

	@Override
	public EmployeeDTO retrieveEmployeeById(Integer id) {
		Employee employee = repository.findById(id).get();
		if (employee == null)
			throw new EmployeeNotFoundException("Employee id = " + id + " not found. Please enter different id");
		return EmployeeMapper.mapToEmployeeDTO(employee);
	}

	@Override
	public List<EmployeeDTO> retrieveAllEmployees() {
		List<Employee> employees = repository.findAll();
		return employees.stream().map(EmployeeMapper::mapToEmployeeDTO).collect(Collectors.toList());
	}

	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
		Employee existingEmployee = repository.findById(employeeDTO.getId()).get();
		if (existingEmployee == null)
			throw new EmployeeNotFoundException(
					"Employee id = " + employeeDTO.getId() + " not found. Please enter different id");

		existingEmployee.setAge(employeeDTO.getAge());
		existingEmployee.setEmail(employeeDTO.getEmail());
		existingEmployee.setEmployeeNumber(employeeDTO.getEmployeeNumber());
		existingEmployee.setFirstName(employeeDTO.getFirstName());
		existingEmployee.setLastName(employeeDTO.getLastName());
		existingEmployee.setPhone(employeeDTO.getPhone());

		Employee updatedEmployee = repository.save(existingEmployee);
		return EmployeeMapper.mapToEmployeeDTO(updatedEmployee);
	}

	@Override
	public void deleteEmployee(Integer id) {
		repository.deleteById(id);
	}

	@Override
	public List<EmployeeDTO> retrieveAllEmployeesByGender(String gender) {
		List<Employee> employees = repository.findAll();
		return employees.stream().filter(emp -> emp.getGender().equalsIgnoreCase(gender))
				.map(EmployeeMapper::mapToEmployeeDTO).collect(Collectors.toList());
	}
}
