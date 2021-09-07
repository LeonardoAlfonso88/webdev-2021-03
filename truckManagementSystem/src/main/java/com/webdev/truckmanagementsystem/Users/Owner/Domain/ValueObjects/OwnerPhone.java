package com.webdev.truckmanagementsystem.Users.Owner.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.StringValueObject;

public class OwnerPhone extends StringValueObject {

    public OwnerPhone(String phone) {
        validate(phone);
        this.value = phone;
    }

    private void validate(String phone) {
    }
}
