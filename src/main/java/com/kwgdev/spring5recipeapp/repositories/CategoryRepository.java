package com.kwgdev.spring5recipeapp.repositories;

import com.kwgdev.spring5recipeapp.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * created by kw on 8/12/2020 @ 11:59 PM
 */
public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
