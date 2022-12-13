package com.onlinestoreboot.repository.impl;

import com.onlinestoreboot.model.Category;
import com.onlinestoreboot.repository.interf.CustomCategoryRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Custom repository class for {@link Category} entity
 */
@Component
public class CategoryRepositoryImpl implements CustomCategoryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Updates a row in the categories table
     *
     * @param category Category entity to update in the database
     */
    @Override
    public void update(Category category) {
        entityManager.merge(category);
    }

    /**
     * Deletes a row in the categories table
     *
     * @param category Category entity to delete from the database
     */
    @Override
    public void deleteCategory(Category category) {
        entityManager.createQuery("delete from Category where id = :id")
                .setParameter("id", category.getId())
                .executeUpdate();
    }

}
