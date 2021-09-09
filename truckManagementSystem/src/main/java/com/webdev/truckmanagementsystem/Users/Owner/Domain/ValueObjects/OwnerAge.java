package com.webdev.truckmanagementsystem.Users.Owner.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.IntegerValueObject;
import com.webdev.truckmanagementsystem.Users.Owner.Domain.Exceptions.OwnerAgeNotValid;

public class OwnerAge extends IntegerValueObject {

    public OwnerAge(Integer age) {
        validate(age);
        this.value = age;
    }

    private void validate(Integer age) {
        validAge(age);
    }

    private void validAge(Integer age) {
        if (age < 18 || age > 120) {
            throw new OwnerAgeNotValid("La edad del propietario no se encuentra en el rango permitido ");
        }
    }
}
