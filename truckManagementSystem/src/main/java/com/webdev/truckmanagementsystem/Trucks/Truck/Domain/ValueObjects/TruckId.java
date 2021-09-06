package com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.CustomUUID;

public class TruckId extends CustomUUID {
    public TruckId(String value) {
        super(value);
    }
}
