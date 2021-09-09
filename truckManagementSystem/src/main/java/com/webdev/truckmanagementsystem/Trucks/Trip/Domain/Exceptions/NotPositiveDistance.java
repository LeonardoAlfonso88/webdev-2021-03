package com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Exceptions;

public class NotPositiveDistance extends RuntimeException {
    public NotPositiveDistance(String message) {
        super(message);
    }
}
