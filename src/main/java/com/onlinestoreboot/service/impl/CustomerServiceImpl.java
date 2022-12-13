package com.onlinestoreboot.service.impl;

import com.onlinestoreboot.dto.CustomerDto;
import com.onlinestoreboot.exception.WrongPasswordException;
import com.onlinestoreboot.repository.interf.CustomerRepository;
import com.onlinestoreboot.model.Customer;
import com.onlinestoreboot.service.interf.CustomerService;
import com.onlinestoreboot.service.interf.RoleService;
import com.onlinestoreboot.statistics.CustomerStatistics;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * Service responsible for operations on customers
 */
@Service
@RequiredArgsConstructor
@Log4j2
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleService roleService;

    /**
     * Creates a new customer
     *
     * @param customer Customer entity to be created
     */
    @Override
    @Transactional
    public void create(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer can't be null");
        }

        customer.setRoles(Collections.singletonList(roleService.getOne("ROLE_USER")));
        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
        customerRepository.save(customer);
        log.info("User " + customer.getEmail() + " was created");
    }

    /**
     * Updates transmitted customer
     *
     * @param customerDto Customer entity to be updated
     */
    @Override
    @Transactional
    public void update(CustomerDto customerDto) {
        if (customerDto == null) {
            throw new IllegalArgumentException("Customer can't be null");
        }

        Customer customer = getCurrentUser();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setDateOfBirth(customerDto.getDateOfBirth());
        customer.setEmail(customerDto.getEmail());

        if (bCryptPasswordEncoder.matches(customerDto.getOldPassword(), customer.getPassword())) {
            if (!customerDto.getNewPassword().trim().isEmpty()) {
                customer.setPassword(bCryptPasswordEncoder.encode(customerDto.getNewPassword()));
            }
        } else {
            throw new WrongPasswordException("Old password is wrong!");
        }

        customerRepository.update(customer);
        log.info("User " + customerDto.getEmail() + " was updated");
    }

    /**
     * Returns the list of all customers
     *
     * @return {@link List} of {@link Customer}
     */
    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    /**
     * Returns the customer by email
     *
     * @param email Email of customer to get
     * @return {@link Customer}
     */
    @Override
    public Customer getOne(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email can't be null or empty");
        }

        return customerRepository.findByEmail(email).orElseThrow();
    }

    /**
     * Returns current logged customer
     *
     * @return {@link Customer}
     */
    @Override
    public Customer getCurrentUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return customerRepository.findByEmail(userDetails.getUsername()).orElseThrow();
    }

    /**
     * Returns the list of the top ten customers
     *
     * @return {@link List} of {@link CustomerStatistics}
     */
    @Override
    public List<CustomerStatistics> getTopTenCustomers() {
        return customerRepository.getTopTenCustomers();
    }
}
