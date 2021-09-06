package com.webdev.truckmanagementsystem.Users.Owner.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.StringValueObject;

public class OwnerIdentificationNumber extends StringValueObject {

    public OwnerIdentificationNumber(String identification) {
        validate(identification);
        this.value = identification;
    }

    private void validate(String identification) {
    }
}
