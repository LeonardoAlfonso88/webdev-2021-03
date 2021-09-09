package com.webdev.truckmanagementsystem.Users.Driver.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.truckmanagementsystem.Shared.Domain.Exceptions.IdentificationNumberRequired;

public class DriverIdentificationNumber extends StringValueObject {

    public DriverIdentificationNumber(String identification) {
        validate(identification);
        this.value = identification;
    }

    private void validate(String identification) {
        requiredIdentification(identification);
    }

    private void requiredIdentification(String identification) {
        if (identification.length() < 0) {
            throw new IdentificationNumberRequired("El documento de identidad no puede estar vacío");
        }
    }
}
