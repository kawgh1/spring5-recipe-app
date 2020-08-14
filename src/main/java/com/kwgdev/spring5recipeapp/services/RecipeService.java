package com.kwgdev.spring5recipeapp.services;

import com.kwgdev.spring5recipeapp.commands.RecipeCommand;
import com.kwgdev.spring5recipeapp.domain.Recipe;

import java.util.Set;

/**
 * created by kw on 8/12/2020 @ 11:58 PM
 */
public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe findById(Long l);
    RecipeCommand findCommandById(Long l);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
