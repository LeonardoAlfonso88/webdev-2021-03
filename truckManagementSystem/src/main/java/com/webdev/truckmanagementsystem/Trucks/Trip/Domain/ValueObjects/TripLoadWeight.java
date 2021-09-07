package com.webdev.truckmanagementsystem.Trucks.Trip.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.DoubleValueObject;
import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.StringValueObject;

public class TripLoadWeight extends DoubleValueObject {

    public TripLoadWeight(Double weight) {
        validate(weight);
        this.value = weight;
    }

    private void validate(Double weight) {
    }
}
