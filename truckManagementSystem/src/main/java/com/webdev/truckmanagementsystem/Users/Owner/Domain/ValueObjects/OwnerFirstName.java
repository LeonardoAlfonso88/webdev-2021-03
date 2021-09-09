package com.webdev.truckmanagementsystem.Users.Owner.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.truckmanagementsystem.Users.Owner.Domain.Exceptions.OwnerNameNotValid;

public class OwnerFirstName extends StringValueObject {

    public OwnerFirstName(String firstName) {
        validate(firstName);
        this.value = firstName;
    }

    private void validate(String firstName) {
        firstNameLenght(firstName);
    }

    private void firstNameLenght(String firstName) {
        Integer lenght = firstName.length();
        if (lenght < 3 || lenght > 20) {
            throw new OwnerNameNotValid("Los nombres del propietario deben tener entre 3 y 20 caracteres");
        }
    }
}
