package com.onlinestoreboot.dto;

import com.onlinestoreboot.model.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO class of {@link Category} entity
 */
@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private Long id;
    private String name;

}
