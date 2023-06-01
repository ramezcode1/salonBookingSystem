package com.app.salonbooking.exception;

public class ServiceItemNotFoundException extends RuntimeException {

    public ServiceItemNotFoundException(String message) {
        super(message);
    }
}
