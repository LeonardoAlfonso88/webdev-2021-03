package com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.StringValueObject;

public class TruckId extends StringValueObject {

    private TruckId() {}

    public TruckId(String Id) {
        this.value = Id;
    }
}
