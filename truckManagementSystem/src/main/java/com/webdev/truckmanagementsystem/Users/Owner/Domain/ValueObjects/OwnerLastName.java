package com.webdev.truckmanagementsystem.Users.Owner.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.StringValueObject;

public class OwnerLastName extends StringValueObject {

    public OwnerLastName(String lastName) {
        validate(lastName);
        this.value = lastName;
    }

    private void validate(String lastName) {
    }
}
