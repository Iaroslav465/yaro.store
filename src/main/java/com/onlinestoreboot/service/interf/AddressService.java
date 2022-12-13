package com.onlinestoreboot.service.interf;

import com.onlinestoreboot.model.Address;

import java.util.List;

/**
 * Service interface responsible for operations on addresses
 */
public interface AddressService {

    void create(Address address);

    void update(Address address);

    void delete(Address address);

    List<Address> getAll();

    Address getOne(long id);

    List<Address> getByCustomerId(long customerId);

    List<Address> getByCustomerEmail(String email);
}
