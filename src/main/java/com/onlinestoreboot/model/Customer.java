package com.onlinestoreboot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

/**
 * Entity of customers table
 */
@Entity
@Table(name = "customers", schema = "public")
@NoArgsConstructor
@Getter
@Setter
public class Customer implements UserDetails, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "first_name", length = 50, nullable = false)
    @NotBlank
    @Size(min = 2, max = 50)
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    @NotBlank
    @Size(min = 2, max = 50)
    private String lastName;

    @Column(name = "date_of_birth", nullable = false)
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @Column(name = "email", length = 50, unique = true, nullable = false)
    @NotBlank
    @Email
    private String email;

    @Column(name = "password", nullable = false)
    @NotBlank
    @Size(min = 6, max = 255)
    @Pattern(regexp = "^\\S+$")
    private String password;

    @ManyToMany
    @JoinTable(name = "roles_of_customers",
            joinColumns = {@JoinColumn(name = "customer_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "role_id", nullable = false)})
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Role> roles;

    @OneToMany(mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Address> addresses;

    @OneToMany(mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Order> orders;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
