package com.onlinestoreboot.service.interf;

import com.onlinestoreboot.model.Order;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Service interface responsible for operations on orders
 */
public interface OrderService {

    void create(Order order);

    void update(Order order);

    List<Order> getAll();

    Order getOne(long id);

    List<Order> getByCustomer(long customerId);

    Order getLast(String email);

    BigInteger getLastWeekIncome();

    BigInteger getLastMonthIncome();
}
