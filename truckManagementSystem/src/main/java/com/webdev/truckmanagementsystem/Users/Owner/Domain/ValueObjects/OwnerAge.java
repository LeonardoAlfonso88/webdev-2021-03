package com.webdev.truckmanagementsystem.Users.Owner.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.IntegerValueObject;

public class OwnerAge extends IntegerValueObject {

    public OwnerAge(Integer age) {
        validate(age);
        this.value = age;
    }

    private void validate(Integer age) {
    }
}
