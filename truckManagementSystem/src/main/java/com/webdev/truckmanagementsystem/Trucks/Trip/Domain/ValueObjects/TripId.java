package com.webdev.truckmanagementsystem.Trucks.Trip.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.CustomUUID;

public class TripId extends CustomUUID {
    public TripId(String value) {
        super(value);
    }
}
