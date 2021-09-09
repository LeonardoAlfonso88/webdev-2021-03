package com.webdev.truckmanagementsystem.Users.Driver.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.CustomUUID;

public class DriverId extends CustomUUID {
    public DriverId(String value) {
        super(value);
    }
}
