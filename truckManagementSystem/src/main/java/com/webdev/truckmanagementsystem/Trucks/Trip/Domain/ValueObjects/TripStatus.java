package com.webdev.truckmanagementsystem.Trucks.Trip.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Exceptions.NotValidState;

import java.util.Arrays;
import java.util.List;

public class TripStatus extends StringValueObject {

    public TripStatus(String status) {
        validate(status);
        this.value = status;
    }

    private void validate(String status) {
        validState(status);
    }

    private void validState(String status) {
        List<String> states = Arrays.asList("start", "process", "finalized");
        if (!states.contains(value)) {
            throw new NotValidState("El estado del viaje no se encuentra entre los permitidos");
        }
    }
}
