package com.onlinestoreboot.service;

import com.onlinestoreboot.config.TestConfig;
import com.onlinestoreboot.service.interf.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
public class CategoryServiceImplTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void categoryShouldNotBeNullWhenCreate() {
        assertThrows(IllegalArgumentException.class, () -> categoryService.create(null));
    }

    @Test
    public void categoryShouldNotBeNullWhenUpdate() {
        assertThrows(IllegalArgumentException.class, () -> categoryService.update(null));
    }

    @Test
    public void categoryShouldNotBeNullWhenDelete() {
        assertThrows(IllegalArgumentException.class, () -> categoryService.delete(null));
    }

    @Test
    public void categoryIdShouldNotBeLessThanOne() {
        assertThrows(IllegalArgumentException.class, () -> categoryService.getOne(0));
    }

    @Test
    public void categoryNameShouldNotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> categoryService.getByName(null));
    }

    @Test
    public void categoryNameShouldNotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> categoryService.getByName(""));
    }
}
