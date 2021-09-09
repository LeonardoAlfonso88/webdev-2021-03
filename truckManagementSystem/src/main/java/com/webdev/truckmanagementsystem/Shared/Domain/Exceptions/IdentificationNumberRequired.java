package com.webdev.truckmanagementsystem.Shared.Domain.Exceptions;

public class IdentificationNumberRequired extends RuntimeException {
    public IdentificationNumberRequired(String message) {
        super(message);
    }
}
