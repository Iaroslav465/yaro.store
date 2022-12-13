package com.onlinestoreboot.converter;

import com.onlinestoreboot.dto.CategoryDto;
import com.onlinestoreboot.model.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Converter for Category entity and CategoryDto
 */
@Component
public class CategoryConverter {

    /**
     * Convert Category entity to CategoryDto
     *
     * @param category Category entity to convert
     * @return {@link CategoryDto}
     */
    public CategoryDto convertToDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());

        return categoryDto;
    }

    /**
     * Convert CategoryDto to Category entity
     *
     * @param categoryDto CategoryDto to convert
     * @return {@link Category}
     */
    public Category convertToEntity(CategoryDto categoryDto) {
        Category category = new Category();

        if (categoryDto.getId() != null) {
            category.setId(categoryDto.getId());
        }

        category.setName(categoryDto.getName());

        return category;
    }

    /**
     * Convert List of Category entities to List of CategoryDto
     *
     * @param categories List of Category entities to convert
     * @return {@link List} of {@link CategoryDto}
     */
    public List<CategoryDto> convertToListOfDto(List<Category> categories) {
        List<CategoryDto> categoriesDto = new ArrayList<>();
        for (Category category : categories) {
            categoriesDto.add(convertToDto(category));
        }
        return categoriesDto;
    }

    /**
     * Convert List of CategoryDto to List of Category entities
     *
     * @param categoriesDto List of CategoryDto to convert
     * @return {@link List} of {@link Category}
     */
    public List<Category> convertToListOfEntity(List<CategoryDto> categoriesDto) {
        List<Category> categories = new ArrayList<>();
        for (CategoryDto categoryDto : categoriesDto) {
            categories.add(convertToEntity(categoryDto));
        }
        return categories;
    }
}
