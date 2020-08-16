package com.kwgdev.spring5recipeapp.services;

import com.kwgdev.spring5recipeapp.commands.IngredientCommand;

/**
 * created by kw on 8/16/2020 @ 12:27 AM
 */
public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);


}
