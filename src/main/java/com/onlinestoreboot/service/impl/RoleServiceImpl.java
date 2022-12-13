package com.onlinestoreboot.service.impl;

import com.onlinestoreboot.repository.interf.RoleRepository;
import com.onlinestoreboot.model.Role;
import com.onlinestoreboot.service.interf.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service responsible for operations on roles
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    /**
     * Returns the list of all roles
     *
     * @return {@link List} of {@link Role}
     */
    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    /**
     * Returns the role by id
     *
     * @param name Id of role to get
     * @return {@link Role}
     */
    @Override
    public Role getOne(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Role name can't be null or empty");
        }

        return roleRepository.findByName(name).orElseThrow();
    }
}
