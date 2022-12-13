package com.onlinestoreboot.dto;

import com.onlinestoreboot.model.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO class of {@link Address} entity
 */
@NoArgsConstructor
@Getter
@Setter
public class AddressDto {

    private Long id;
    private String customerDto;
    private String country;
    private String city;
    private String zipCode;
    private String street;
    private Integer building;
    private Integer apartment;

    @Override
    public String toString() {
        return apartment + " " + street + " " + building + ", " + city + ", " + country + ", " + zipCode;
    }
}
