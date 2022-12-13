package com.onlinestoreboot.repository.impl;

import com.onlinestoreboot.repository.interf.CustomProductRepository;
import com.onlinestoreboot.model.Category;
import com.onlinestoreboot.model.Product;
import com.onlinestoreboot.model.enumeration.PaymentStatus;
import com.onlinestoreboot.statistics.ProductStatistics;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Custom repository class for {@link Product} entity
 */
@Component
public class ProductRepositoryImpl implements CustomProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Updates a row in the products table
     *
     * @param product Product entity to update in the database
     */
    @Override
    public void update(Product product) {
        entityManager.merge(product);
    }

    /**
     * Filters products by their fields
     *
     * @param category Category name
     * @param name     Product name or its part
     * @param minPrice Minimum price include minPrice
     * @param maxPrice Maximum price include maxPrice
     * @param brand    Product brand
     * @param color    Product color
     * @return {@link List} of {@link Product}
     */
    @Override
    public List<Product> filter(String category, String name, int minPrice,
                                int maxPrice, String brand, String color) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);

        Predicate predicate = criteriaBuilder.ge(root.get("price"), minPrice);
        predicate = criteriaBuilder.and(predicate, criteriaBuilder.le(root.get("price"), maxPrice));
        predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("deleted"), false));

        if (category != null) {
            Path<Category> categoryPath = root.get("category");
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(
                    criteriaBuilder.upper(categoryPath.get("name")), "%" + category.toUpperCase() + "%"));
        }

        if (name != null && !name.isEmpty()) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(
                    criteriaBuilder.upper(root.get("name")), "%" + name.toUpperCase() + "%"));
        }

        if (brand != null && !brand.isEmpty()) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(
                    criteriaBuilder.upper(root.get("brand")), "%" + brand.toUpperCase() + "%"));
        }

        if (color != null && !color.isEmpty()) {
            predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(
                    criteriaBuilder.upper(root.get("color")), "%" + color.toUpperCase() + "%"));
        }

        return entityManager.createQuery(criteriaQuery.select(root).where(predicate)).getResultList();
    }

    /**
     * Returns the list of the top ten products
     *
     * @return {@link List} of {@link ProductStatistics}
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<ProductStatistics> getTopTenProducts() {
        List<Object[]> result = entityManager.createQuery("select p.upc, p.name, p.color, p.brand, p.category.name, p.price," +
                " sum (po.numberOfProducts) as quantitySold" +
                " from Product p" +
                " left join ProductsInOrder po on p.upc = po.product.upc" +
                " left join Order o on o.id = po.order.id" +
                " where o.paymentStatus = :paymentStatus" +
                " and p.deleted = false" +
                " group by p.upc, p.category.name" +
                " order by quantitySold desc")
                .setParameter("paymentStatus", PaymentStatus.PAID)
                .setMaxResults(10)
                .getResultList();

        if (result == null) {
            return new ArrayList<>();
        }

        List<ProductStatistics> productsStatistics = new ArrayList<>();

        for (Object[] objects : result) {
            ProductStatistics productStatistics = new ProductStatistics();
            productStatistics.setUpc((Long) objects[0]);
            productStatistics.setName((String) objects[1]);
            productStatistics.setColor((String) objects[2]);
            productStatistics.setBrand((String) objects[3]);
            productStatistics.setCategory((String) objects[4]);
            productStatistics.setPrice((Integer) objects[5]);
            productStatistics.setQuantitySold((Long) objects[6]);
            productsStatistics.add(productStatistics);
        }

        return productsStatistics;
    }
}
