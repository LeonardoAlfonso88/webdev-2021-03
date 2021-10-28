package com.webdev.truckmanagementsystem.Shared.Domain.Ids;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.CustomUUID;

public class TruckId extends CustomUUID {
    private TruckId() {}

    public TruckId(String value) {
        super(value);
    }
}
