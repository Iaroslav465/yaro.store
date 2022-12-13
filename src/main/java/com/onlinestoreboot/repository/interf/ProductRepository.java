package com.onlinestoreboot.repository.interf;

import com.onlinestoreboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository for Product entity
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, CustomProductRepository {

    List<Product> findAllByCategory_Name(String name);

    Optional<Product> findByUpc(long upc);

}
