package com.onlinestoreboot.service.interf;

import com.onlinestoreboot.model.Role;

import java.util.List;

/**
 * Service interface responsible for operations on roles
 */
public interface RoleService {

    List<Role> getAll();

    Role getOne(String name);
}
