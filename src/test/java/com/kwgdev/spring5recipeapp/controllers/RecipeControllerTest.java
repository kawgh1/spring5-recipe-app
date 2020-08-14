package com.kwgdev.spring5recipeapp.controllers;

import com.kwgdev.spring5recipeapp.domain.Recipe;
import com.kwgdev.spring5recipeapp.services.RecipeService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * created by kw on 8/14/2020 @ 4:07 AM
 */
public class RecipeControllerTest {

    @Mock
    RecipeService recipeService;

    RecipeController controller;

    MockMvc mockMvc;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        controller = new RecipeController(recipeService);

    }

    @Test
    public void testGetRecipe() throws Exception {

        Recipe recipe = new Recipe();
        recipe.setId(1L);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        when(recipeService.findById(anyLong())).thenReturn(recipe);

        mockMvc.perform(MockMvcRequestBuilders.get("/recipe/show/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("recipe/show"))
                .andExpect(MockMvcResultMatchers.model().attributeExists("recipe"));
    }

//    @Test
//    public void stestGetRecipe() throws Exception {
//
//        Recipe recipe = new Recipe();
//        recipe.setId(1L);
//
//        when(recipeService.findById(anyLong())).thenReturn(recipe);
//
//        mockMvc.perform(get("/recipe/1/show"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("recipe/show"))
//                .andExpect(model().attributeExists("recipe"));
//    }




}