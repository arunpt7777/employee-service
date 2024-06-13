package com.motta.employee_service.mapper;

import com.motta.employee_service.entity.Address;
import com.motta.employee_service.entity.Address.AddressType;
import com.motta.employee_service.model.AddressDTO;

public class AddressMapper {

	// Convert Address JPA Entity into AddressDTO
	public static AddressDTO mapToAddressDTO(Address address) {
		AddressDTO addressDTO = new AddressDTO(address.getId(), address.getAddressLine1(), address.getAddressLine2(),
				address.getZipCode(), address.getAddressType().toString());
		return addressDTO;
	}

	// Convert AddressDTO into Address JPA Entity
	public static Address mapToAddress(AddressDTO addressDTO) {

		AddressType addressType = AddressType.valueOf(addressDTO.getAddressType());

		Address address = new Address(addressDTO.getId(), addressDTO.getAddressLine1(), addressDTO.getAddressLine2(),
				addressDTO.getZipCode(), addressType);
		return address;
	}
}
