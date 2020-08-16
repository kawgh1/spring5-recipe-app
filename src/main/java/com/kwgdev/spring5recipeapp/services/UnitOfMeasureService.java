package com.kwgdev.spring5recipeapp.services;

import com.kwgdev.spring5recipeapp.commands.UnitOfMeasureCommand;
import com.kwgdev.spring5recipeapp.domain.UnitOfMeasure;

import java.util.Set;

/**
 * created by kw on 8/16/2020 @ 12:56 AM
 */
public interface UnitOfMeasureService {
    Set<UnitOfMeasureCommand> listAllUoms();


}
