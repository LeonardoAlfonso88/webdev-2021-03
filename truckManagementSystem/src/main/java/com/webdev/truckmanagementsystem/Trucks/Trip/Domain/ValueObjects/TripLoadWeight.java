package com.webdev.truckmanagementsystem.Trucks.Trip.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.DoubleValueObject;
import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Exceptions.WeightOutRange;

public class TripLoadWeight extends DoubleValueObject {

    public TripLoadWeight(Double weight) {
        validate(weight);
        this.value = weight;
    }

    private void validate(Double weight) {
        validWeight(weight);
    }

    private void validWeight(Double weight) {
        if (weight > 15000 || weight < 2000) {
            throw new WeightOutRange("El peso de la carga debe estar entre 2000Kg y 15000kg");
        }
    }
}
