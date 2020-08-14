package com.kwgdev.spring5recipeapp.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * created by kw on 8/13/2020 @ 9:24 PM
 */
public class CategoryTest {

    Category category;

    @Before
    public void setup() {
        category = new Category();
    }

    @Test
    public void getId() {
        Long idValue = 4L;
        category.setId(4L);
        assertEquals(idValue, category.getId());
    }

    @Test
    public void getDescription() {
    }

    @Test
    public void getRecipes() {
    }
}