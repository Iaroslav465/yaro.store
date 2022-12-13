package com.onlinestoreboot.service.interf;

import com.onlinestoreboot.dto.CustomerDto;
import com.onlinestoreboot.model.Customer;
import com.onlinestoreboot.statistics.CustomerStatistics;

import java.util.List;

/**
 * Service interface responsible for operations on customers
 */
public interface CustomerService {

    void create(Customer customer);

    void update(CustomerDto customerDto);

    List<Customer> getAll();

    Customer getOne(String email);

    Customer getCurrentUser();

    List<CustomerStatistics> getTopTenCustomers();
}
