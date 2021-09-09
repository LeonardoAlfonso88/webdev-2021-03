package com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Exceptions;

public class NotValidTripPlace extends RuntimeException {
    public NotValidTripPlace(String message) {
        super(message);
    }
}
