package com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Exceptions;

public class TripNotExist extends RuntimeException{
    public TripNotExist(String message) {
        super(message);
    }
}
