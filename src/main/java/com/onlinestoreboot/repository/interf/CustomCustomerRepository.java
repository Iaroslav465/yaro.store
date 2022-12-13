package com.onlinestoreboot.repository.interf;

import com.onlinestoreboot.model.Customer;
import com.onlinestoreboot.statistics.CustomerStatistics;

import java.util.List;

public interface CustomCustomerRepository {

    void update(Customer customer);

    List<CustomerStatistics> getTopTenCustomers();

}
