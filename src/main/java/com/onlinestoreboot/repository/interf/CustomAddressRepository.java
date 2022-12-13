package com.onlinestoreboot.repository.interf;

import com.onlinestoreboot.model.Address;

import java.util.List;

public interface CustomAddressRepository {

    void update(Address address);

    void deleteAddress(Address address);

    List<Address> getByCustomerId(long customerId);

}
