package com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions;

public class NotPositiveInsuranceValue extends RuntimeException {
    public NotPositiveInsuranceValue(String message) {
        super(message);
    }
}
