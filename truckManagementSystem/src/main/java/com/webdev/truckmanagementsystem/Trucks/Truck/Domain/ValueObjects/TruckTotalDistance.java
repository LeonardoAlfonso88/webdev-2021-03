package com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.DoubleValueObject;

public class TruckTotalDistance extends DoubleValueObject {

    private TruckTotalDistance() {}

    public TruckTotalDistance(Double distance) {
        validate(distance);
        this.value = distance;
    }

    private void validate(Double distance) {

    }
}
