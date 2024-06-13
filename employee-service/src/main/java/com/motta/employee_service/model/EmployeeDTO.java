package com.motta.employee_service.model;

public class EmployeeDTO {

	private Integer id;
	private Integer employeeNumber;
	private Integer age;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String gender;
	private Integer salaryId;

	public EmployeeDTO() {
	}

	public EmployeeDTO(Integer id, Integer employeeNumber, Integer age, String firstName, String lastName, String email,
			String phone, String gender, Integer salaryId) {
		super();
		this.id = id;
		this.employeeNumber = employeeNumber;
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getSalaryId() {
		return salaryId;
	}

	public void setSalaryId(Integer salaryId) {
		this.salaryId = salaryId;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", employeeNumber=" + employeeNumber + ", age=" + age + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone + ", gender=" + gender
				+ ", salaryId=" + salaryId + "]";
	}

}
