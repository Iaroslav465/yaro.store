package com.onlinestoreboot.converter;

import com.onlinestoreboot.dto.RoleDto;
import com.onlinestoreboot.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Converter for Role entity and RoleDto
 */
@Component
public class RoleConverter {

    /**
     * Convert Role entity to RoleDto
     *
     * @param role Role entity to convert
     * @return {@link RoleDto}
     */
    public RoleDto convertToDto(Role role) {
        RoleDto roleDto = new RoleDto();

        roleDto.setId(role.getId());
        roleDto.setName(role.getName());

        return roleDto;
    }

    /**
     * Convert RoleDto to Role entity
     *
     * @param roleDto RoleDto to convert
     * @return {@link Role}
     */
    public Role convertToEntity(RoleDto roleDto) {
        Role role = new Role();

        role.setId(roleDto.getId());
        role.setName(roleDto.getName());

        return role;
    }

    /**
     * Convert List of Role entities to List of RoleDto
     *
     * @param roles List of Role entities to convert
     * @return {@link List} of {@link RoleDto}
     */
    public List<RoleDto> convertToListOfDto(List<Role> roles) {
        List<RoleDto> rolesDto = new ArrayList<>();
        for (Role role : roles) {
            rolesDto.add(convertToDto(role));
        }
        return rolesDto;
    }

    /**
     * Convert List of RoleDto to List of Role entities
     *
     * @param rolesDto List of RoleDto to convert
     * @return {@link List} of {@link Role}
     */
    public List<Role> convertToListOfEntity(List<RoleDto> rolesDto) {
        List<Role> roles = new ArrayList<>();
        for (RoleDto roleDto : rolesDto) {
            roles.add(convertToEntity(roleDto));
        }
        return roles;
    }
}
