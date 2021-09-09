package com.webdev.truckmanagementsystem.Users.Owner.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.truckmanagementsystem.Shared.Domain.Exceptions.IdentificationNumberRequired;

public class OwnerPhone extends StringValueObject {

    public OwnerPhone(String phone) {
        validate(phone);
        this.value = phone;
    }

    private void validate(String phone) {
        formatPhone(phone);
    }

    private void formatPhone(String phone) {
        if (phone.length() < 0) {
            throw new IdentificationNumberRequired("El número de teléfono no tiene un formato correcto");
        }
    }
}
