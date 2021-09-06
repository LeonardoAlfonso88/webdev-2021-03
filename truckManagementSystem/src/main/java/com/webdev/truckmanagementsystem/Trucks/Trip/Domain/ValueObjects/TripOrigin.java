package com.webdev.truckmanagementsystem.Trucks.Trip.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.StringValueObject;

public class TripOrigin extends StringValueObject {

    public TripOrigin(String origin) {
        validate(origin);
        this.value = origin;
    }

    private void validate(String origin) {
    }
}
