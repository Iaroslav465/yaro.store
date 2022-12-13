package com.onlinestoreboot.service;

import com.onlinestoreboot.config.TestConfig;
import com.onlinestoreboot.service.interf.AddressService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
public class AddressServiceImplTest {

    @Autowired
    private AddressService addressService;

    @Test
    public void addressShouldNotBeNullWhenCreate() {
        assertThrows(IllegalArgumentException.class, () -> addressService.create(null));
    }

    @Test
    public void addressShouldNotBeNullWhenUpdate() {
        assertThrows(IllegalArgumentException.class, () -> addressService.update(null));
    }

    @Test
    public void addressShouldNotBeNullWhenDelete() {
        assertThrows(IllegalArgumentException.class, () -> addressService.delete(null));
    }

    @Test
    public void addressIdShouldNotBeLessThanOne() {
        assertThrows(IllegalArgumentException.class, () -> addressService.getOne(0));
    }

    @Test
    public void customerIdShouldNotBeLessThanOne() {
        assertThrows(IllegalArgumentException.class, () -> addressService.getByCustomerId(0));
    }

    @Test
    public void customerEmailShouldNotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> addressService.getByCustomerEmail(null));
    }

    @Test
    public void customerEmailShouldNotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> addressService.getByCustomerEmail(""));
    }
}
