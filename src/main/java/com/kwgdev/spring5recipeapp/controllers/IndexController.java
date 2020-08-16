package com.kwgdev.spring5recipeapp.controllers;

import com.kwgdev.spring5recipeapp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * created by kw on 8/12/2020 @ 11:57 PM
 */
@Controller
@Slf4j
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        log.debug("SLF4J:  Getting Index page");
        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
