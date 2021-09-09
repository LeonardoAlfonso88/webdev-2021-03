package com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Exceptions;

public class WeightOutRange extends RuntimeException {
    public WeightOutRange(String message) {
        super(message);
    }
}
