package com.webdev.truckmanagementsystem.Trucks.Trip.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.StringValueObject;

public class TripStatus extends StringValueObject {

    public TripStatus(String status) {
        validate(status);
        this.value = status;
    }

    private void validate(String status) {
    }
}
