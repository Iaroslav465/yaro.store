package com.onlinestoreboot.repository.impl;

import com.onlinestoreboot.model.Address;
import com.onlinestoreboot.repository.interf.CustomAddressRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Custom repository class for {@link Address} entity
 */
@Component
public class AddressRepositoryImpl implements CustomAddressRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Updates a row in the addresses table
     *
     * @param address Address entity to update in the database
     */
    @Override
    public void update(Address address) {
        entityManager.merge(address);
    }

    /**
     * Deletes a row in the addresses table
     *
     * @param address Address entity to delete from the database
     */
    @Override
    public void deleteAddress(Address address) {
        entityManager.createQuery("delete from Address where id = :id")
                .setParameter("id", address.getId())
                .executeUpdate();
    }

    /**
     * Returns the list of addresses of customer
     *
     * @param customerId Id of customer to get addresses from the database
     * @return {@link List} of {@link Address}
     */
    @Override
    public List<Address> getByCustomerId(long customerId) {
        TypedQuery<Address> query = entityManager.createQuery(
                "select a from Address a where a.customer.id = :customerId",
                Address.class
        );
        query.setParameter("customerId", customerId);
        return query.getResultList();
    }

}
