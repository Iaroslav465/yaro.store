package com.onlinestoreboot.dto;

import com.onlinestoreboot.model.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO class of {@link Product} entity
 */
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {

    private Long upc;
    private String categoryDto;
    private String name;
    private Integer price;
    private String brand;
    private String color;
    private Integer weight;
    private Integer height;
    private Integer width;
    private Integer depth;
    private Integer inStock;
    private Boolean deleted;
    private String imagePath;

}
