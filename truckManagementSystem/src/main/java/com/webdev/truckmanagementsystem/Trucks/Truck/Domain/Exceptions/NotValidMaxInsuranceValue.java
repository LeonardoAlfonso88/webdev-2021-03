package com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions;

public class NotValidMaxInsuranceValue extends RuntimeException {
    public NotValidMaxInsuranceValue(String message) {
        super(message);
    }
}
