package com.onlinestoreboot.service;

import com.onlinestoreboot.config.TestConfig;
import com.onlinestoreboot.model.Order;
import com.onlinestoreboot.service.interf.ProductsInOrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
public class ProductsInOrderImplTest {

    @Autowired
    private ProductsInOrderService productsInOrderService;

    @Test
    public void orderShouldNotBeNullWhenCreate() {
        Map<Long, Integer> cart = new HashMap<>();
        cart.put(1L, 2);
        assertThrows(IllegalArgumentException.class, () -> productsInOrderService.create(null, cart));
    }

    @Test
    public void cartShouldNotBeNullWhenCreate() {
        assertThrows(IllegalArgumentException.class, () -> productsInOrderService.create(new Order(), null));
    }

    @Test
    public void cartShouldNotBeEmptyWhenCreate() {
        assertThrows(IllegalArgumentException.class, () -> productsInOrderService.create(new Order(), new HashMap<>()));
    }

    @Test
    public void productsInOrderIdShouldNotBeLessThanOne() {
        assertThrows(IllegalArgumentException.class, () -> productsInOrderService.getOne(0));
    }
}
