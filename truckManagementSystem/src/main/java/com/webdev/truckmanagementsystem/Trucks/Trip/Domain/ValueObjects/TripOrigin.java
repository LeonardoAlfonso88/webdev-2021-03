package com.webdev.truckmanagementsystem.Trucks.Trip.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Exceptions.NotValidTripPlace;

public class TripOrigin extends StringValueObject {

    public TripOrigin(String origin) {
        validate(origin);
        this.value = origin;
    }

    private void validate(String origin) {
        originFormat(origin);
    }

    private void originFormat(String origin) {
        if (origin.length() != 3) {
            throw new NotValidTripPlace("El origen del viaje está limitado a su abreviatura de 3 letras.");
        }
    }
}
