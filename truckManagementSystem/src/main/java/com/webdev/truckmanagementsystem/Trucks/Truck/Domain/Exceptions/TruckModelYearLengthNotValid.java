package com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions;

public class TruckModelYearLengthNotValid extends RuntimeException {
    public TruckModelYearLengthNotValid(String message) {
        super(message);
    }
}
