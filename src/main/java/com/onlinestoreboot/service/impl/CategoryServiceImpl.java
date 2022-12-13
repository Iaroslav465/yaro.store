package com.onlinestoreboot.service.impl;

import com.onlinestoreboot.repository.interf.CategoryRepository;
import com.onlinestoreboot.repository.interf.ProductRepository;
import com.onlinestoreboot.model.Category;
import com.onlinestoreboot.model.Product;
import com.onlinestoreboot.service.interf.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service responsible for operations on categories
 */
@Service
@RequiredArgsConstructor
@Log4j2
@Transactional(readOnly = true)
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    /**
     * Creates a new category
     *
     * @param category Category entity to be created
     */
    @Override
    @Transactional
    public void create(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Category can't be null");
        }

        categoryRepository.save(category);
        log.info("Category \"" + category.getName() + "\" was created");
    }

    /**
     * Updates transmitted category and initializes update of statistics in advertising stands
     *
     * @param category Category entity to be updated
     */
    @Override
    @Transactional
    public void update(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Category can't be null");
        }

        categoryRepository.update(category);
        log.info("Category \"" + category.getName() + "\" was updated");
    }

    /**
     * Deletes transmitted category and initializes update of statistics in advertising stands
     *
     * @param category Category entity to be deleted
     */
    @Override
    @Transactional
    public void delete(Category category) {
        if (category == null) {
            throw new IllegalArgumentException("Category can't be null");
        }

        List<Product> products = productRepository.findAllByCategory_Name(category.getName());
        for (Product product : products) {
            product.setCategory(categoryRepository.findByName("Other Equipment").orElseThrow());
            productRepository.update(product);
            productRepository.flush();
        }

        categoryRepository.deleteCategory(category);
        log.info("Category \"" + category.getName() + "\" was deleted");
    }

    /**
     * Returns the list of all categories
     *
     * @return {@link List} of {@link Category}
     */
    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    /**
     * Returns the category by id
     *
     * @param id ID of category to get
     * @return {@link Category}
     */
    @Override
    public Category getOne(long id) {
        if (id < 1) {
            throw new IllegalArgumentException("Category id can't be less than 1");
        }

        return categoryRepository.findById(id).orElseThrow();
    }

    /**
     * Returns the category by name
     *
     * @param name Name of category to get
     * @return {@link Category}
     */
    @Override
    public Category getByName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Category name can't be null or empty");
        }

        return categoryRepository.findByName(name).orElseThrow();
    }
}
