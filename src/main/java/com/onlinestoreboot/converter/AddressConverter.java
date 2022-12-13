package com.onlinestoreboot.converter;

import com.onlinestoreboot.dto.AddressDto;
import com.onlinestoreboot.model.Address;
import com.onlinestoreboot.service.interf.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Converter for Address entity and AddressDto
 */
@Component
@RequiredArgsConstructor
public class AddressConverter {

    private final CustomerService customerService;

    /**
     * Convert Address entity to AddressDto
     *
     * @param address Address entity to convert
     * @return {@link AddressDto}
     */
    public AddressDto convertToDto(Address address) {
        AddressDto addressDto = new AddressDto();

        addressDto.setId(address.getId());
        addressDto.setCustomerDto(address.getCustomer().getEmail());
        addressDto.setCountry(address.getCountry());
        addressDto.setCity(address.getCity());
        addressDto.setZipCode(address.getZipCode());
        addressDto.setStreet(address.getStreet());
        addressDto.setBuilding(address.getBuilding());
        addressDto.setApartment(address.getApartment());

        return addressDto;
    }

    /**
     * Convert AddressDto to Address entity
     *
     * @param addressDto AddressDto to convert
     * @return {@link Address}
     */
    public Address convertToEntity(AddressDto addressDto) {
        Address address = new Address();

        if (addressDto.getId() != null) {
            address.setId(addressDto.getId());
        }

        address.setCustomer(customerService.getOne(addressDto.getCustomerDto()));
        address.setCountry(addressDto.getCountry());
        address.setCity(addressDto.getCity());
        address.setZipCode(addressDto.getZipCode());
        address.setStreet(addressDto.getStreet());
        address.setBuilding(addressDto.getBuilding());
        address.setApartment(addressDto.getApartment());

        return address;
    }

    /**
     * Convert List of Address entities to List of AddressDto
     *
     * @param addresses List of Address entities to convert
     * @return {@link List} of {@link AddressDto}
     */
    public List<AddressDto> convertToListOfDto(List<Address> addresses) {
        List<AddressDto> addressesDto = new ArrayList<>();
        for (Address address : addresses) {
            addressesDto.add(convertToDto(address));
        }
        return addressesDto;
    }

    /**
     * Convert List of AddressDto to List of Address entities
     *
     * @param addressesDto List of AddressDto to convert
     * @return {@link List} of {@link Address}
     */
    public List<Address> convertToListOfEntity(List<AddressDto> addressesDto) {
        List<Address> addresses = new ArrayList<>();
        for (AddressDto addressDto : addressesDto) {
            addresses.add(convertToEntity(addressDto));
        }
        return addresses;
    }

    /**
     * Convert List of Address entities to List of AddressDto.toString()
     *
     * @param addresses List of Address entities to convert
     * @return {@link List} of {@link String}
     */
    public List<String> convertToListOfString(List<Address> addresses) {
        List<String> stringAddresses = new ArrayList<>();
        for (AddressDto addressDto : convertToListOfDto(addresses)) {
            stringAddresses.add(addressDto.toString());
        }
        return stringAddresses;
    }
}
