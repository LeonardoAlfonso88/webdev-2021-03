package com.webdev.truckmanagementsystem.Shared.Domain.Exceptions;

public class DriverLicenseNotValid extends RuntimeException {
    public DriverLicenseNotValid(String message) {
        super(message);
    }
}
