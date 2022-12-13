package com.onlinestoreboot.repository.interf;

import com.onlinestoreboot.model.Category;

public interface CustomCategoryRepository {

    void update(Category category);

    void deleteCategory(Category category);

}
