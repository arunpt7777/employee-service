package com.motta.employee_service.entity;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Entity
@SequenceGenerator(name = "Custom_Sequence", sequenceName = "custom_sequence", initialValue = 1000, allocationSize = 1)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Custom_Sequence")
	private Integer id;

	@Size(min = 6, max = 6, message = "Please provide at least 6 digits for the employee number")
	@Pattern(regexp = "(^$|[0-9]{10})")
	private Integer employeeNumber;

	@Min(value = 18, message = "Age must be greater than 18")
	@Max(value = 90, message = "Age must be smaller than 90")
	private Integer age;

	@NotEmpty(message = "first name is mandatory")
	private String firstName;

	@NotEmpty(message = "Last name is mandatory")
	private String lastName;

	@NotEmpty(message = "Gender is mandatory")
	private String gender;

	// @Email(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
	private String email;

	@Size(min = 10, max = 10, message = "Phone number must contain only ten digits")
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String phone;

	private Integer salaryId;

	public Employee() {

	}

	public Employee(Integer id, Integer employeeNumber,
			@Min(value = 18, message = "Age must be greater than 18") @Max(value = 90, message = "Age must be smaller than 90") Integer age,
			@NotEmpty(message = "first name is mandatory") String firstName,
			@NotEmpty(message = "Last name is mandatory") String lastName,
			@NotEmpty(message = "Gender is mandatory") String gender, String email, String phone, Integer salaryId) {
		super();
		this.id = id;
		this.employeeNumber = employeeNumber;
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.salaryId = salaryId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(Integer employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getSalaryId() {
		return salaryId;
	}

	public void setSalaryId(Integer salaryId) {
		this.salaryId = salaryId;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeeNumber=" + employeeNumber + ", age=" + age + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + ", email=" + email + ", phone=" + phone
				+ ", salaryId=" + salaryId + "]";
	}

}
