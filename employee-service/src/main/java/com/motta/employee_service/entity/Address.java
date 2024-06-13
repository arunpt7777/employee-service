package com.motta.employee_service.entity;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotEmpty;

@Entity
@SequenceGenerator(name = "Custom_Sequence", sequenceName = "custom_sequence", initialValue = 4, allocationSize = 1)
public class Address {

	public enum AddressType {
		PERMANENT, RESIDENTIAL
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Custom_Sequence")
	private Integer id;

	@NotEmpty(message = "Address Line1 is mandatory")
	private String addressLine1;

	@NotEmpty(message = "Address Line2 is mandatory")
	private String addressLine2;

	@Size(min = 6, max = 6, message = "Zip Code must contain only six digits")
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String zipCode;

	@Enumerated(EnumType.STRING)
	private AddressType addressType;

	public Address() {

	}

	public Address(Integer id, @NotEmpty(message = "Address Line1 is mandatory") String addressLine1,
			@NotEmpty(message = "Address Line2 is mandatory") String addressLine2, String zipCode,
			AddressType addressType) {
		super();
		this.id = id;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.zipCode = zipCode;
		this.addressType = addressType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", zipCode="
				+ zipCode + ", addressType=" + addressType + "]";
	}

}
