package com.onlinestoreboot.converter;

import com.onlinestoreboot.dto.ProductDto;
import com.onlinestoreboot.model.Product;
import com.onlinestoreboot.service.interf.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Converter for Product entity and ProductDto
 */
@Component
@RequiredArgsConstructor
public class ProductConverter {

    private final CategoryService categoryService;

    /**
     * Convert Product entity to ProductDto
     *
     * @param product Product entity to convert
     * @return {@link ProductDto}
     */
    public ProductDto convertToDto(Product product) {
        ProductDto productDto = new ProductDto();

        productDto.setUpc(product.getUpc());
        productDto.setCategoryDto(product.getCategory().getName());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setBrand(product.getBrand());
        productDto.setColor(product.getColor());
        productDto.setWeight(product.getWeight());
        productDto.setHeight(product.getHeight());
        productDto.setWidth(product.getWidth());
        productDto.setDepth(product.getDepth());
        productDto.setInStock(product.getInStock());
        productDto.setDeleted(product.isDeleted());

        if (product.getImagePath() != null) {
            productDto.setImagePath(product.getImagePath());
        }

        return productDto;
    }

    /**
     * Convert ProductDto to Product entity
     *
     * @param productDto ProductDto to convert
     * @return {@link Product}
     */
    public Product convertToEntity(ProductDto productDto) {
        Product product = new Product();

        product.setUpc(productDto.getUpc());
        product.setCategory(categoryService.getByName(productDto.getCategoryDto()));
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setBrand(productDto.getBrand());
        product.setColor(productDto.getColor());
        product.setWeight(productDto.getWeight());
        product.setHeight(productDto.getHeight());
        product.setWidth(productDto.getWidth());
        product.setDepth(productDto.getDepth());
        product.setInStock(productDto.getInStock());
        product.setDeleted(productDto.getDeleted());

        if (productDto.getImagePath() != null) {
            product.setImagePath(productDto.getImagePath());
        }

        return product;
    }

    /**
     * Convert List of Product entities to List of ProductDto
     *
     * @param products List of Product entities to convert
     * @return {@link List} of {@link ProductDto}
     */
    public List<ProductDto> convertToListOfDto(List<Product> products) {
        List<ProductDto> productsDto = new ArrayList<>();
        for (Product product : products) {
            productsDto.add(convertToDto(product));
        }
        return productsDto;
    }

    /**
     * Convert List of ProductDto to List of Product entities
     *
     * @param productsDto List of ProductDto to convert
     * @return {@link List} of {@link Product}
     */
    public List<Product> convertToListOfEntity(List<ProductDto> productsDto) {
        List<Product> products = new ArrayList<>();
        for (ProductDto productDto : productsDto) {
            products.add(convertToEntity(productDto));
        }
        return products;
    }
}
