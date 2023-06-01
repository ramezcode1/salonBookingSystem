package com.app.salonbooking.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ServiceItemNotFoundException.class)
    public String postNotFoundException(ServiceItemNotFoundException e) {
        return "error";
    }

}