package com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Exceptions;

public class NotValidTripFormat extends RuntimeException {
    public NotValidTripFormat(String message) {
        super(message);
    }
}
