package com.onlinestoreboot.repository.interf;

import com.onlinestoreboot.model.Product;
import com.onlinestoreboot.statistics.ProductStatistics;

import java.util.List;

public interface CustomProductRepository {

    void update(Product product);

    List<Product> filter(String category, String name, int minPrice, int maxPrice, String brand, String color);

    List<ProductStatistics> getTopTenProducts();

}
