package com.webdev.truckmanagementsystem.Users.Permission.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.truckmanagementsystem.Shared.Domain.Exceptions.DriverLicenseNotValid;

import java.util.regex.Pattern;

public class PermissionDriverLicenseNumber extends StringValueObject {

    public PermissionDriverLicenseNumber(String license) {
        validate(license);
        this.value = license;
    }

    private void validate(String license) {
        formatLicense(license);
    }

    private void formatLicense(String license) {
        Pattern p = Pattern.compile("^[a-zA-Z0-9]{10}$");
        if (!p.matcher(license).find()) {
            throw new DriverLicenseNotValid("Placa inválida");
        }
    }
}
