package com.horse.race.tracker.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericExceptionController {

    @ExceptionHandler(Exception.class)
    public String handleException() {
       return "ApplicationError";
    }
}