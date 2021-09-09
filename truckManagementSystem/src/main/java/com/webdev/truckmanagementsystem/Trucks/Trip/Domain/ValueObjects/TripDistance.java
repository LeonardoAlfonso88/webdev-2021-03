package com.webdev.truckmanagementsystem.Trucks.Trip.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.DoubleValueObject;
import com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Exceptions.NotPositiveDistance;

public class TripDistance extends DoubleValueObject {

    public TripDistance(Double distance) {
        validate(distance);
        this.value = distance;
    }

    private void validate(Double distance) {
        positiveDistance(distance);
    }

    private void positiveDistance(Double distance) {
        throw new NotPositiveDistance("La distancia no puede ser negativa");
    }
}
