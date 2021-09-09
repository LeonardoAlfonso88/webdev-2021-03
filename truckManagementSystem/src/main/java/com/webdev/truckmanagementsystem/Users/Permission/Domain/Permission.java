package com.webdev.truckmanagementsystem.Users.Permission.Domain;

import com.webdev.truckmanagementsystem.Shared.Domain.Exceptions.IdentificationNumberRequired;
import com.webdev.truckmanagementsystem.Users.Permission.Domain.ValueObjects.*;

import java.util.HashMap;
import java.util.Objects;

public class Permission {

    private PermissionId permissionId;
    private PermissionDriverFirstName firstName;
    private PermissionDriverLastName lastName;
    private PermissionDriverIdentificationNumber identificationNumber;
    private PermissionDriverLicenseNumber licenseNumber;
    private PermissionStatus status;

    public Permission(PermissionId permissionId,
                      PermissionDriverFirstName firstName,
                      PermissionDriverLastName lastName,
                      PermissionDriverIdentificationNumber identificationNumber,
                      PermissionDriverLicenseNumber licenseNumber,
                      PermissionStatus status) {
        this.permissionId = permissionId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.identificationNumber = identificationNumber;
        this.licenseNumber = licenseNumber;
        this.status = status;
    }

    public static Permission Create(PermissionId permissionId,
                      PermissionDriverFirstName firstName,
                      PermissionDriverLastName lastName,
                      PermissionDriverIdentificationNumber identificationNumber,
                      PermissionDriverLicenseNumber licenseNumber,
                      PermissionStatus status) {

        Permission permission = new Permission(permissionId, firstName, lastName, identificationNumber, licenseNumber, status);
        //Events
        return permission;
    }

    public HashMap<String, Object> data() {
        return new HashMap<>() {{
           put("id", permissionId.value());
            put("firstName", firstName.value());
            put("lastName", lastName.value());
            put("identificationNumber", identificationNumber.value());
            put("licenseNumber", licenseNumber.value());
        }};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permission that = (Permission) o;
        return Objects.equals(permissionId, that.permissionId) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(identificationNumber, that.identificationNumber) && Objects.equals(licenseNumber, that.licenseNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permissionId, firstName, lastName, identificationNumber, licenseNumber);
    }
}
