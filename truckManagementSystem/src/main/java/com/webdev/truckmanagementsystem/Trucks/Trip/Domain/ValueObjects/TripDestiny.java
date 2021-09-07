package com.webdev.truckmanagementsystem.Trucks.Trip.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.StringValueObject;

public class TripDestiny extends StringValueObject {

    public TripDestiny(String destiny) {
        validate(destiny);
        this.value = destiny;
    }

    private void validate(String destiny) {
    }
}
