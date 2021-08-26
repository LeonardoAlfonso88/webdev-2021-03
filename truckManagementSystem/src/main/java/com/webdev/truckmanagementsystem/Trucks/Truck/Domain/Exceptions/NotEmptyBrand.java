package com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions;

public class NotEmptyBrand extends RuntimeException {
    public NotEmptyBrand(String message) {
        super(message);
    }
}
