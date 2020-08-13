package com.kwgdev.spring5recipeapp.repositories;

import com.kwgdev.spring5recipeapp.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * created by kw on 8/12/2020 @ 11:59 PM
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
