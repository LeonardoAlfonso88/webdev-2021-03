package com.webdev.truckmanagementsystem.Users.Driver.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.truckmanagementsystem.Shared.Domain.Exceptions.DriverNameNotValid;

public class DriverLastName extends StringValueObject {

    public DriverLastName(String lastName) {
        validate(lastName);
        this.value = lastName;
    }

    private void validate(String lastName) {
        firstNameLenght(lastName);
    }

    private void firstNameLenght(String lastName) {
        int lenght = lastName.length();
        if (lenght < 5 || lenght > 25) {
            throw new DriverNameNotValid("Los apellidos del conductor debe tener entre 5 y 25 caracteres");
        }
    }
}
