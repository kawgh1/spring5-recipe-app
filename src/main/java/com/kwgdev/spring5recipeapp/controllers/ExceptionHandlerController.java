package com.kwgdev.spring5recipeapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * created by kw on 8/17/2020 @ 5:40 AM
 */

@Slf4j
@ControllerAdvice
public class ExceptionHandlerController {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView handleNumberFormatExc (Exception exception) {

        log.error("Handling Number Format Exception");
        log.error(exception.getMessage());

        ModelAndView mav = new ModelAndView();

        mav.setViewName("400error");
        mav.addObject("exception", exception);


        return mav;
    }
}
