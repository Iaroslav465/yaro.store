package com.onlinestoreboot.service;

import com.onlinestoreboot.config.TestConfig;
import com.onlinestoreboot.service.interf.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
public class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Test
    public void productShouldNotBeNullWhenCreate() {
        assertThrows(IllegalArgumentException.class, () -> productService.create(null));
    }

    @Test
    public void productShouldNotBeNullWhenUpdate() {
        assertThrows(IllegalArgumentException.class, () -> productService.update(null));
    }

    @Test
    public void upcShouldNotBeLessThanOneWhenGetOne() {
        assertThrows(IllegalArgumentException.class, () -> productService.getOne(0));
    }

    @Test
    public void minPriceShouldNotBeLessThanZero() {
        assertThrows(IllegalArgumentException.class, () -> productService.filter("test", "test",
                -1, 1, "test", "test"));
    }

    @Test
    public void maxPriceShouldNotBeLessThanZero() {
        assertThrows(IllegalArgumentException.class, () -> productService.filter("test", "test",
                0, -1, "test", "test"));
    }

    @Test
    public void cartShouldBeEmpty() {
        assertEquals(new HashMap<>(), productService.getProductsFromCart(null));
    }

    @Test
    public void upcShouldNotBeLessThanOneWhenCheckNumberOfProducts() {
        assertThrows(IllegalArgumentException.class, () -> productService.checkNumberOfProducts(0, 1));
    }

    @Test
    public void quantityShouldNotBeLessThanOneWhenCheckNumberOfProducts() {
        assertThrows(IllegalArgumentException.class, () -> productService.checkNumberOfProducts(1, 0));
    }
}
