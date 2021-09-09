package com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Exceptions;

public class NotValidState extends RuntimeException {
    public NotValidState(String message) {
        super(message);
    }
}
