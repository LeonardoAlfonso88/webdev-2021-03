package com.webdev.truckmanagementsystem.Users.Permission.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Exceptions.NotValidState;

import java.util.Arrays;
import java.util.List;

public class PermissionStatus extends StringValueObject {

    public PermissionStatus(String status) {
        validate(status);
        this.value = status;
    }

    private void validate(String status) {
        validState(status);
    }

    private void validState(String status) {
        List<String> states = Arrays.asList("proccess", "accepted", "rejected");
        if (!states.contains(value)) {
            throw new NotValidState("El estado del permiso no se encuentra entre los permitidos");
        }
    }
}
