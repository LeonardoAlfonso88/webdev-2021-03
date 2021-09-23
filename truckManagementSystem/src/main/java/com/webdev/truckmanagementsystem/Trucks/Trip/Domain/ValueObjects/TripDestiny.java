package com.webdev.truckmanagementsystem.Trucks.Trip.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Exceptions.NotValidTripPlace;

public class TripDestiny extends StringValueObject {

    private TripDestiny() {

    }

    public TripDestiny(String destiny) {
        validate(destiny);
        this.value = destiny;
    }

    private void validate(String destiny) {
        destinyFormat(destiny);
    }

    private void destinyFormat(String destiny) {
        if (destiny.length() != 3) {
            throw new NotValidTripPlace("El destino del viaje está limitado a su abreviatura de 3 letras.");
        }
    }
}
