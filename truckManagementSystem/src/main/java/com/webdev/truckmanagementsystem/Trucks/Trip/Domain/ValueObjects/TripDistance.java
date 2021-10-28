package com.webdev.truckmanagementsystem.Trucks.Trip.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.DoubleValueObject;
import com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Exceptions.NotPositiveDistance;

public class TripDistance extends DoubleValueObject {

    private TripDistance() {

    }

    public TripDistance(Double distance) {
        validate(distance);
        this.value = distance;
    }

    private void validate(Double distance) {
        positiveDistance(distance);
    }

    private void positiveDistance(Double distance) {
        Double base = Double.parseDouble("0");
        if(distance.compareTo(base) <= 0) {
            throw new NotPositiveDistance("La distancia no puede ser negativa");
        }
    }
}
