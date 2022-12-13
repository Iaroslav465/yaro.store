package com.onlinestoreboot.repository.interf;

import com.onlinestoreboot.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for Order entity
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, CustomOrderRepository {

    List<Order> findAllByCustomer_Id(long id);

}
