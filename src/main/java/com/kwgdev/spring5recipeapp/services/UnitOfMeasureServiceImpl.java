package com.kwgdev.spring5recipeapp.services;

import com.kwgdev.spring5recipeapp.commands.UnitOfMeasureCommand;
import com.kwgdev.spring5recipeapp.converters.UnitOfMeasureToUnitOfMeasureCommand;
import com.kwgdev.spring5recipeapp.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * created by kw on 8/16/2020 @ 12:56 AM
 */
@Slf4j
@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService{

    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository,
                                    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.unitOfMeasureToUnitOfMeasureCommand = unitOfMeasureToUnitOfMeasureCommand;
    }

    @Override
    public Set<UnitOfMeasureCommand> listAllUoms() {

        return StreamSupport.stream(unitOfMeasureRepository.findAll()
                .spliterator(), false)
                // use map function to convert our domain objects into command objects
                .map(unitOfMeasureToUnitOfMeasureCommand::convert)
                // then collect them into a set and return them
                .collect(Collectors.toSet());
    }
}
