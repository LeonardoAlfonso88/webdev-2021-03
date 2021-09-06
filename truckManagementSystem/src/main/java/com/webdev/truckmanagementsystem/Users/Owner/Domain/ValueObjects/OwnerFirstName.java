package com.webdev.truckmanagementsystem.Users.Owner.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.StringValueObject;

public class OwnerFirstName extends StringValueObject {

    public OwnerFirstName(String firstName) {
        validate(firstName);
        this.value = firstName;
    }

    private void validate(String distance) {
    }
}
