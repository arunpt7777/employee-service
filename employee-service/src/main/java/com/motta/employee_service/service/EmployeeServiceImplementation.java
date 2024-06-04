package com.motta.employee_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motta.employee_service.entity.Employee;
import com.motta.employee_service.mapper.EmployeeMapper;
import com.motta.employee_service.model.EmployeeDTO;
import com.motta.employee_service.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

		// Convert EmployeeDTO into User JPA Entity
		Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
		Employee savedEmployee = repository.save(employee);

		// Convert Employee JPA entity to UserDto
		EmployeeDTO savedEmployeeDTO = EmployeeMapper.mapToEmployeeDTO(savedEmployee);
		return savedEmployeeDTO;
	}

	@Override
	public EmployeeDTO retrieveEmployeeById(Integer id) {
		Employee employee = repository.findById(id).get();
		return EmployeeMapper.mapToEmployeeDTO(employee);
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		List<Employee> employees = repository.findAll();
		return employees.stream().map(EmployeeMapper::mapToEmployeeDTO).collect(Collectors.toList());
	}

	@Override
	public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
		Employee existingEmployee = repository.findById(employeeDTO.getId()).get();
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
}
