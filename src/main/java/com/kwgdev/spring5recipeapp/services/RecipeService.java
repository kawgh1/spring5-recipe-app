package com.kwgdev.spring5recipeapp.services;

import com.kwgdev.spring5recipeapp.domain.Recipe;

import java.util.Set;

/**
 * created by kw on 8/12/2020 @ 11:58 PM
 */
public interface RecipeService {

    Set<Recipe> getRecipes();
}
