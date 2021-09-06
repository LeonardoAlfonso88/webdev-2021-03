package com.webdev.truckmanagementsystem.Trucks.Trip.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.DoubleValueObject;

public class TripDistance extends DoubleValueObject {

    public TripDistance(Double distance) {
        validate(distance);
        this.value = distance;
    }

    private void validate(Double distance) {
    }
}
