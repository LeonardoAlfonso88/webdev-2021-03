package com.webdev.truckmanagementsystem.Shared.Domain.Ids;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.CustomUUID;

public class OwnerId extends CustomUUID {
    public OwnerId(String ownerId) {
        super(ownerId);
    }
}
