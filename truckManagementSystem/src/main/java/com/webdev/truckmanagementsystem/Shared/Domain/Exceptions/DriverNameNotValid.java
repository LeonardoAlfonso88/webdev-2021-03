package com.webdev.truckmanagementsystem.Shared.Domain.Exceptions;

public class DriverNameNotValid extends RuntimeException {
    public DriverNameNotValid(String message) {
        super(message);
    }
}
