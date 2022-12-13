package com.onlinestoreboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * Entity of roles table
 */
@Entity
@Table(name = "roles", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Role implements GrantedAuthority, Serializable {

    public Role(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "role_id")
    private Long id;

    @Column(name = "name", length = 20, nullable = false, unique = true)
    @NotBlank
    @Size(min = 1, max = 20)
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<Customer> customers;

    @Override
    public String getAuthority() {
        return getName();
    }
}
