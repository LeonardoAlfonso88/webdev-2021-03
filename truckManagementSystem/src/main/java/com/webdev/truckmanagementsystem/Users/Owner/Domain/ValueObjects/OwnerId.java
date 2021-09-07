package com.webdev.truckmanagementsystem.Users.Owner.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.CustomUUID;

public class OwnerId extends CustomUUID {
    public OwnerId(String ownerId) {
        super(ownerId);
    }
}
