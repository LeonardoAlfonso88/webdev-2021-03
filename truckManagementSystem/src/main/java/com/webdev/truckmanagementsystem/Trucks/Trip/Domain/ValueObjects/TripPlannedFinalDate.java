package com.webdev.truckmanagementsystem.Trucks.Trip.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.StringValueObject;

public class TripPlannedFinalDate extends StringValueObject {

    public TripPlannedFinalDate(String date) {
        validate(date);
        this.value = date;
    }

    private void validate(String date) {
    }
}
