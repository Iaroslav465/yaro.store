package com.onlinestoreboot.service.impl;

import com.onlinestoreboot.repository.interf.AddressRepository;
import com.onlinestoreboot.model.Address;
import com.onlinestoreboot.service.interf.AddressService;
import com.onlinestoreboot.service.interf.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service responsible for operations on addresses
 */
@Service
@RequiredArgsConstructor
@Log4j2
@Transactional(readOnly = true)
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final CustomerService customerService;

    /**
     * Creates a new address
     *
     * @param address Address entity to be created
     */
    @Override
    @Transactional
    public void create(Address address) {
        if (address == null) {
            throw new IllegalArgumentException("Address can't be null");
        }

        addressRepository.save(address);
        log.info("User " + address.getCustomer().getEmail() + " create address " + address);
    }

    /**
     * Updates transmitted address
     *
     * @param address Address entity to be updated
     */
    @Override
    @Transactional
    public void update(Address address) {
        if (address == null) {
            throw new IllegalArgumentException("Address can't be null");
        }

        addressRepository.update(address);
        log.info("User " + address.getCustomer().getEmail() + " update address " + address);
    }

    /**
     * Deletes transmitted address
     *
     * @param address Address entity to be deleted
     */
    @Override
    @Transactional
    public void delete(Address address) {
        if (address == null) {
            throw new IllegalArgumentException("Address can't be null");
        }

        addressRepository.deleteAddress(address);
        log.info("User " + address.getCustomer().getEmail() + " delete address " + address);
    }

    /**
     * Returns the list of all addresses
     *
     * @return {@link List} of {@link Address}
     */
    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    /**
     * Returns the address by id
     *
     * @param id ID of address to get
     * @return {@link Address}
     */
    @Override
    public Address getOne(long id) {
        if (id < 1) {
            throw new IllegalArgumentException("Address id can't be less than 1");
        }

        return addressRepository.findById(id).orElseThrow();
    }

    /**
     * Returns the list of addresses of customer by its id
     *
     * @param customerId ID of customer to get addresses
     * @return {@link List} of {@link Address}
     */
    @Override
    public List<Address> getByCustomerId(long customerId) {
        if (customerId < 1) {
            throw new IllegalArgumentException("Customer id can't be less than 1");
        }

        return addressRepository.getByCustomerId(customerId);
    }

    /**
     * Returns the list of addresses of customer by its email
     *
     * @param email Email of customer to get addresses
     * @return {@link List} of {@link Address}
     */
    @Override
    public List<Address> getByCustomerEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Customer email can't be null or empty");
        }

        return addressRepository.getByCustomerId(customerService.getOne(email).getId());
    }
}
