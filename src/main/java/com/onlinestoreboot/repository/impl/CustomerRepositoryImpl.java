package com.onlinestoreboot.repository.impl;

import com.onlinestoreboot.repository.interf.CustomCustomerRepository;
import com.onlinestoreboot.model.Customer;
import com.onlinestoreboot.model.enumeration.PaymentStatus;
import com.onlinestoreboot.statistics.CustomerStatistics;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Custom repository class for {@link Customer} entity
 */
@Component
public class CustomerRepositoryImpl implements CustomCustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Updates a row in the customers table
     *
     * @param customer Customer entity to update in the database
     */
    @Override
    public void update(Customer customer) {
        entityManager.merge(customer);
    }

    /**
     * Returns the list of the top ten customers
     *
     * @return {@link List} of {@link CustomerStatistics}
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<CustomerStatistics> getTopTenCustomers() {
        List<Object[]> result = entityManager.createQuery("select c.firstName, c.lastName, c.email," +
                " sum (o.total) as purchasesTotal" +
                " from Customer c" +
                " left join Order o on o.customer.id = c.id" +
                " where o.paymentStatus = :paymentStatus" +
                " and o.total > 0" +
                " group by c.id" +
                " order by purchasesTotal desc")
                .setParameter("paymentStatus", PaymentStatus.PAID)
                .setMaxResults(10)
                .getResultList();

        if (result == null) {
            return new ArrayList<>();
        }

        List<CustomerStatistics> customersStatistics = new ArrayList<>();

        for (Object[] objects : result) {
            CustomerStatistics customerStatistics = new CustomerStatistics();
            customerStatistics.setFirstName((String) objects[0]);
            customerStatistics.setLastName((String) objects[1]);
            customerStatistics.setEmail((String) objects[2]);
            customerStatistics.setPurchasesTotal((Long) objects[3]);
            customersStatistics.add(customerStatistics);
        }

        return customersStatistics;
    }
}
