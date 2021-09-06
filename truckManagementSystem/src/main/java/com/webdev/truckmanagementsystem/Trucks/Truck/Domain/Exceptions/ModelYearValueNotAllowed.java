package com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions;

public class ModelYearValueNotAllowed extends RuntimeException {
    public ModelYearValueNotAllowed(String message) {
        super(message);
    }
}
