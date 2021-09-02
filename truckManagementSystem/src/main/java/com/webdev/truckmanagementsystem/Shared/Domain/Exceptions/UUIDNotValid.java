package com.webdev.truckmanagementsystem.Shared.Domain.Exceptions;

public class UUIDNotValid extends RuntimeException {
    public UUIDNotValid(String message) {
        super(message);
    }
}
