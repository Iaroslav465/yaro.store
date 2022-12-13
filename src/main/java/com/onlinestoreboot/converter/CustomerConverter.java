package com.onlinestoreboot.converter;

import com.onlinestoreboot.dto.CustomerDto;
import com.onlinestoreboot.model.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Converter for Customer entity and CustomerDto
 */
@Component
public class CustomerConverter {

    /**
     * Convert customer entity to CustomerDto
     *
     * @param customer Customer entity to convert
     * @return {@link CustomerDto}
     */
    public CustomerDto convertToDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();

        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setDateOfBirth(customer.getDateOfBirth());
        customerDto.setEmail(customer.getEmail());
        customerDto.setOldPassword(customer.getPassword());
        customerDto.setNewPassword(customer.getPassword());

        return customerDto;
    }

    /**
     * Convert CustomerDto to customer entity
     *
     * @param customerDto CustomerDto to convert
     * @return {@link Customer}
     */
    public Customer convertToEntity(CustomerDto customerDto) {
        Customer customer = new Customer();

        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setDateOfBirth(customerDto.getDateOfBirth());
        customer.setEmail(customerDto.getEmail());
        if (customerDto.getNewPassword().trim().isEmpty()) {
            customer.setPassword(customerDto.getOldPassword());
        } else {
            customer.setPassword(customerDto.getNewPassword());
        }

        return customer;
    }

    /**
     * Convert List of Customer entities to List of CustomerDto
     *
     * @param customers List of Customer entities to convert
     * @return {@link List} of {@link CustomerDto}
     */
    public List<CustomerDto> convertToListOfDto(List<Customer> customers) {
        List<CustomerDto> customersDto = new ArrayList<>();
        for (Customer customer : customers) {
            customersDto.add(convertToDto(customer));
        }
        return customersDto;
    }

    /**
     * Convert List of CustomerDto to List of Customer entities
     *
     * @param customersDto List of CustomerDto to convert
     * @return {@link List} of {@link Customer}
     */
    public List<Customer> convertToListOfEntity(List<CustomerDto> customersDto) {
        List<Customer> customers = new ArrayList<>();
        for (CustomerDto customerDto : customersDto) {
            customers.add(convertToEntity(customerDto));
        }
        return customers;
    }
}
