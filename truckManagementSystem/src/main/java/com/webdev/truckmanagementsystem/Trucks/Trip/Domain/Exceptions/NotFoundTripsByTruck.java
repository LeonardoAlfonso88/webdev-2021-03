package com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Exceptions;

public class NotFoundTripsByTruck extends RuntimeException {
    public NotFoundTripsByTruck(String message) {
        super(message);
    }
}
