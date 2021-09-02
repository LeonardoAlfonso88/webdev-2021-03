package com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions;

public class PlateFormatNotValid extends RuntimeException {
    public PlateFormatNotValid(String message) {
        super(message);
    }
}
