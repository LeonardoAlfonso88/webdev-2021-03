package com.webdev.truckmanagementsystem.Users.Permission.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.truckmanagementsystem.Shared.Domain.Exceptions.DriverNameNotValid;

public class PermissionDriverFirstName extends StringValueObject {

    public PermissionDriverFirstName(String firstName) {
        validate(firstName);
        this.value = firstName;
    }

    private void validate(String firstName) {
        firstNameLenght(firstName);
    }

    private void firstNameLenght(String firstName) {
        int lenght = firstName.length();
        if (lenght < 5 || lenght > 25) {
            throw new DriverNameNotValid("Los nombres del conductor solicitante debe tener entre 5 y 25 caracteres");
        }
    }
}
