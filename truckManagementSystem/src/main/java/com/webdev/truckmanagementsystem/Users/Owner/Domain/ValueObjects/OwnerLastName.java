package com.webdev.truckmanagementsystem.Users.Owner.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.truckmanagementsystem.Users.Owner.Domain.Exceptions.OwnerNameNotValid;

public class OwnerLastName extends StringValueObject {

    public OwnerLastName(String lastName) {
        validate(lastName);
        this.value = lastName;
    }

    private void validate(String lastName) {
        lastNameLenght(lastName);
    }

    private void lastNameLenght(String lastName) {
        Integer lenght = lastName.length();
        if (lenght < 3 || lenght > 20) {
            throw new OwnerNameNotValid("Los apellidos del propietario deben tener entre 3 y 20 caracteres");
        }
    }
}
