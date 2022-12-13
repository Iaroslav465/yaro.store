package com.onlinestoreboot.repository.interf;

import com.onlinestoreboot.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository for Category entity
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>, CustomCategoryRepository {

    Optional<Category> findByName(String name);

}
