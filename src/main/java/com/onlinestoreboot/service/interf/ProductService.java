package com.onlinestoreboot.service.interf;

import com.onlinestoreboot.dto.ProductDto;
import com.onlinestoreboot.model.Product;
import com.onlinestoreboot.statistics.ProductStatistics;

import java.util.List;
import java.util.Map;

/**
 * Service interface responsible for operations on products
 */
public interface ProductService {

    void create(Product product);

    void update(Product product);

    List<Product> getAll();

    Product getOne(long upc);

    List<Product> filter(String category, String name, int minPrice,
                         int maxPrice, String brand, String color);

    List<ProductStatistics> getTopTenProducts();

    Map<ProductDto, Integer> getProductsFromCart(Map<Long, Integer> cart);

    boolean checkNumberOfProducts(long upc, int quantity);
}
