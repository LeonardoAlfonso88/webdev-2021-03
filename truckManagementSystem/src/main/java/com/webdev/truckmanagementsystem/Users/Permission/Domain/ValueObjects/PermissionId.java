package com.webdev.truckmanagementsystem.Users.Permission.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.CustomUUID;

public class PermissionId extends CustomUUID {
    public PermissionId(String value) {
        super(value);
    }
}
