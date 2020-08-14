package com.kwgdev.spring5recipeapp.controllers;

import com.kwgdev.spring5recipeapp.domain.Recipe;
import com.kwgdev.spring5recipeapp.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

// import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;     NOT FOUND
// import org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;    NOT FOUND
import org.springframework.ui.Model;

import javax.persistence.criteria.CriteriaBuilder;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

/**
 * created by kw on 8/13/2020 @ 9:40 PM
 */
public class IndexControllerTest {
    @Mock
    RecipeService recipeService;
    @Mock
    Model model;

    IndexController controller;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);

        controller = new IndexController(recipeService);

    }

    @Test
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        // MockMvcRequestBuilders and Matchers are static imports, had to slow type and let Intellij find them

        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("index"));
    }

    @Test
    public void getIndexPage() {

        //given
        Set<Recipe> recipes = new HashSet<>();
        recipes.add(new Recipe());

        // adding Id otherwise these two no arg recipes are taken as the same recipe, as only 1
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        recipes.add(recipe);

        when(recipeService.getRecipes()).thenReturn(recipes);

        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        // when
        String viewName = controller.getIndexPage(model);

        // then
        assertEquals("index", viewName);
        verify(recipeService, times(1)).getRecipes();
        // verify(model, times(1)).addAttribute(eq("recipes"),anySet());
        verify(model, times(1)).addAttribute(eq("recipes"),argumentCaptor.capture());
        Set<Recipe> setInController = argumentCaptor.getValue();
        assertEquals(2,setInController.size());

    }
}