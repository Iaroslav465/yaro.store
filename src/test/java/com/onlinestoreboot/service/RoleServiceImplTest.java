package com.onlinestoreboot.service;

import com.onlinestoreboot.config.TestConfig;
import com.onlinestoreboot.service.interf.RoleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
public class RoleServiceImplTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void roleNameShouldNotBeNull() {
        assertThrows(IllegalArgumentException.class, () -> roleService.getOne(null));
    }

    @Test
    public void roleNameShouldNotBeEmpty() {
        assertThrows(IllegalArgumentException.class, () -> roleService.getOne(""));
    }
}
