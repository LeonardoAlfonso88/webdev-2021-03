package com.webdev.truckmanagementsystem.Users.Driver.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.truckmanagementsystem.Shared.Domain.Exceptions.DriverNameNotValid;

public class DriverFirstName extends StringValueObject {

    public DriverFirstName(String firstName) {
        validate(firstName);
        this.value = firstName;
    }

    private void validate(String firstName) {
        firstNameLenght(firstName);
    }

    private void firstNameLenght(String firstName) {
        int lenght = firstName.length();
        if (lenght < 3 || lenght > 20) {
            throw new DriverNameNotValid("Los nombres del conductor debe tener entre 3 y 20 caracteres");
        }
    }
}
