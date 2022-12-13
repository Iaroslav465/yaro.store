package com.onlinestoreboot.service;

import com.onlinestoreboot.config.TestConfig;
import com.onlinestoreboot.repository.interf.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
public class UserDetailsServiceImplTest {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private CustomerRepository customerRepository;

    private static final String email = "any@gmail.com";

    @Test
    public void emailShouldNotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> userDetailsService.loadUserByUsername(null));
    }

    @Test
    public void emailShouldNotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> userDetailsService.loadUserByUsername(""));
    }

    @Test
    public void customerShouldExist() {
        when(customerRepository.findByEmail(email)).thenReturn(Optional.empty());
        assertThrows(UsernameNotFoundException.class, () -> userDetailsService.loadUserByUsername(email));
    }
}
