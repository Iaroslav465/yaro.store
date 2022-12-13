package com.onlinestoreboot.repository.impl;

import com.onlinestoreboot.repository.interf.CustomOrderRepository;
import com.onlinestoreboot.model.Order;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

/**
 * Custom repository class for {@link Order} entity
 */
@Component
public class OrderRepositoryImpl implements CustomOrderRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Updates a row in the orders table
     *
     * @param order Order entity to update in the database
     */
    @Override
    public void update(Order order) {
        entityManager.merge(order);
    }

    /**
     * Returns the last order of customer
     *
     * @param email Email of customer to get the last order from the database
     * @return {@link Order}
     */
    @Override
    public Order getLast(String email) {
        TypedQuery<Order> query = entityManager.createQuery(
                "select o from Order o where o.customer.email = :email order by o.dateOfSale desc",
                Order.class
        );
        query.setParameter("email", email);
        return query.getResultList().stream().findFirst().orElse(null);
    }

    /**
     * Returns income for the last week
     *
     * @return {@link BigDecimal}
     */
    @Override
    @SuppressWarnings("unchecked ")
    public BigInteger getLastWeekIncome() {
        List<BigInteger> result = entityManager.createNativeQuery("select sum(total) from orders" +
                " where payment_status_id <> 0 and date_of_sale >= now() - INTERVAL '7 day'").getResultList();

        for (BigInteger number : result) {
            if (number == null) {
                return BigInteger.ZERO;
            }
        }

        return result.stream().findAny().orElse(BigInteger.ZERO);
    }

    /**
     * Returns income for the last month
     *
     * @return {@link BigDecimal}
     */
    @Override
    @SuppressWarnings("unchecked ")
    public BigInteger getLastMonthIncome() {
        List<BigInteger> result = entityManager.createNativeQuery("select sum(total) from orders" +
                " where payment_status_id <> 0 and date_of_sale >= now() - INTERVAL '30 day'").getResultList();

        for (BigInteger number : result) {
            if (number == null) {
                return BigInteger.ZERO;
            }
        }

        return result.stream().findAny().orElse(BigInteger.ZERO);
    }
}
