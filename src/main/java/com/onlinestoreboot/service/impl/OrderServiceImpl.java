package com.onlinestoreboot.service.impl;

import com.onlinestoreboot.repository.interf.OrderRepository;
import com.onlinestoreboot.model.Order;
import com.onlinestoreboot.service.interf.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Service responsible for operations on orders
 */
@Service
@RequiredArgsConstructor
@Log4j2
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    /**
     * Creates a new order
     *
     * @param order Order entity to be created
     */
    @Override
    @Transactional
    public void create(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order can't be null");
        }

        orderRepository.save(order);
        log.info("Order #" + order.getId() + " for customer " + order.getCustomer().getEmail() + " was created");
    }

    /**
     * Updates transmitted order
     *
     * @param order Order entity to be updated
     */
    @Override
    @Transactional
    public void update(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order can't be null");
        }

        orderRepository.update(order);
        log.info("Order #" + order.getId() + " for customer " + order.getCustomer().getEmail() + " was updated");
    }

    /**
     * Returns the list of all orders
     *
     * @return {@link List} of {@link Order}
     */
    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    /**
     * Returns the order by id
     *
     * @param id ID of order to get
     * @return {@link Order}
     */
    @Override
    public Order getOne(long id) {
        if (id < 1) {
            throw new IllegalArgumentException("Order id can't be less than 1");
        }

        return orderRepository.findById(id).orElseThrow();
    }

    /**
     * Returns the list of orders of customer by its id
     *
     * @param customerId ID of customer to get orders
     * @return {@link List} of {@link Order}
     */
    @Override
    public List<Order> getByCustomer(long customerId) {
        if (customerId < 1) {
            throw new IllegalArgumentException("Customer id can't be less than 1");
        }

        return orderRepository.findAllByCustomer_Id(customerId);
    }

    /**
     * Returns the last order of customer
     *
     * @param email Email of customer to get the last order
     * @return {@link Order}
     */
    @Override
    public Order getLast(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Customer email can't be null or empty");
        }

        return orderRepository.getLast(email);
    }

    /**
     * Returns income for the last week
     *
     * @return {@link BigDecimal}
     */
    @Override
    public BigInteger getLastWeekIncome() {
        return orderRepository.getLastWeekIncome();
    }

    /**
     * Returns income for the last month
     *
     * @return {@link BigDecimal}
     */
    @Override
    public BigInteger getLastMonthIncome() {
        return orderRepository.getLastMonthIncome();
    }
}
