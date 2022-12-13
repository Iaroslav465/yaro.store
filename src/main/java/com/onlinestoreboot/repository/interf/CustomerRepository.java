package com.onlinestoreboot.repository.interf;

import com.onlinestoreboot.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for Customer entity
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomCustomerRepository {

    Optional<Customer> findByEmail(String email);

}
