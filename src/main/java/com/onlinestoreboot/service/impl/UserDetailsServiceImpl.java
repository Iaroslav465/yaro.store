package com.onlinestoreboot.service.impl;

import com.onlinestoreboot.repository.interf.CustomerRepository;
import com.onlinestoreboot.model.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Service required for Spring Security to work
 */
@Service
@RequiredArgsConstructor
@Log4j2
public class UserDetailsServiceImpl implements UserDetailsService {

    private final CustomerRepository customerRepository;

    /**
     * Returns UserDetails for processing by Spring Security
     *
     * @param email Email of customer to process
     * @return {@link UserDetails}
     * @throws UsernameNotFoundException If there is no customer with provided email
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email can't be null or empty");
        }

        Customer customer = customerRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        log.info("User " + customer.getEmail() + " is logged in");
        return customer;
    }
}
