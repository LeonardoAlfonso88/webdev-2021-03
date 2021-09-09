package com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions;

public class NotFoundTrucksOwner extends RuntimeException {
    public NotFoundTrucksOwner(String message) {
        super(message);
    }
}
