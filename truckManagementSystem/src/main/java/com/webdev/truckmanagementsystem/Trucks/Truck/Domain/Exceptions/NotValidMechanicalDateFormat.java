package com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions;

public class NotValidMechanicalDateFormat extends RuntimeException {
    public NotValidMechanicalDateFormat(String message) {
        super(message);
    }
}
