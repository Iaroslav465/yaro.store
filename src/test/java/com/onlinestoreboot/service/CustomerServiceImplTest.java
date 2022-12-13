package com.onlinestoreboot.service;

import com.onlinestoreboot.config.TestConfig;
import com.onlinestoreboot.service.interf.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
public class CustomerServiceImplTest {

    @Autowired
    private CustomerService customerService;

    @Test
    public void customerShouldNotBeNullWhenCreate() {
        assertThrows(IllegalArgumentException.class, () -> customerService.create(null));
    }

    @Test
    public void customerShouldNotBeNullWhenUpdate() {
        assertThrows(IllegalArgumentException.class, () -> customerService.update(null));
    }

    @Test
    public void emailShouldNotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> customerService.getOne(null));
    }

    @Test
    public void emailShouldNotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> customerService.getOne(""));
    }
}
