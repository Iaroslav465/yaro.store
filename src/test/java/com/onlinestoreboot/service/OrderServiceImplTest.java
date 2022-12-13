package com.onlinestoreboot.service;

import com.onlinestoreboot.config.TestConfig;
import com.onlinestoreboot.service.interf.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
public class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void orderShouldNotBeNullWhenCreate() {
        assertThrows(IllegalArgumentException.class, () -> orderService.create(null));
    }

    @Test
    public void orderShouldNotBeNullWhenUpdate() {
        assertThrows(IllegalArgumentException.class, () -> orderService.update(null));
    }

    @Test
    public void orderIdShouldNotBeLessThanOne() {
        assertThrows(IllegalArgumentException.class, () -> orderService.getOne(0));
    }

    @Test
    public void customerIdShouldNotBeLessThanOne() {
        assertThrows(IllegalArgumentException.class, () -> orderService.getByCustomer(0));
    }

    @Test
    public void customerEmailShouldNotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> orderService.getLast(null));
    }

    @Test
    public void customerEmailShouldNotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> orderService.getLast(""));
    }
}
