package com.onlinestoreboot.repository.interf;

import com.onlinestoreboot.model.ProductsInOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for ProductsInOrder entity
 */
public interface ProductsInOrderRepository extends JpaRepository<ProductsInOrder, Long> {
}
