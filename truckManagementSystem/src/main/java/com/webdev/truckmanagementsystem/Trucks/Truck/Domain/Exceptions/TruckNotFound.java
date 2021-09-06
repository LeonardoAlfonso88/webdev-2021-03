package com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions;

public class TruckNotFound extends RuntimeException {
    public TruckNotFound(String message) {
        super(message);
    }
}
