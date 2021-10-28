package com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Exceptions;

public class TripAlreadyExist extends RuntimeException {
    public TripAlreadyExist(String message) {
        super(message);
    }
}
