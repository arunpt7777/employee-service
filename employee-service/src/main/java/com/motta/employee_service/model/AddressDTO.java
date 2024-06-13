package com.motta.employee_service.model;

public class AddressDTO {

	private Integer id;
	private String addressLine1;
	private String addressLine2;
	private String zipCode;
	private String addressType;

	public AddressDTO() {
	}

	public AddressDTO(Integer id, String addressLine1, String addressLine2, String zipCode, String addressType) {
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

	public String getAddressType() {
		return addressType;
	}

	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	@Override
	public String toString() {
		return "AddressDTO [id=" + id + ", addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2
				+ ", zipCode=" + zipCode + ", addressType=" + addressType + "]";
	}

}
