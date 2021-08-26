package com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions.PlateLengthNotValid;

public class TruckPlate extends StringValueObject {

    private TruckPlate() {}

    public TruckPlate(String plate) {
        validate(plate);
        this.value = plate;
    }

    private void validate(String plate) throws RuntimeException {
        lenghtValidate(plate);
        plateLetterValidate(plate);
        plateNumericValidate(plate);
    }

    private void lenghtValidate(String plate) throws RuntimeException {
        if (plate.length() != 6)
        {
            throw new PlateLengthNotValid("La longitud de la placa no es correcta");
        }
    }

    private void plateLetterValidate(String plate) {

    }

    private void plateNumericValidate(String plate) {

    }

}


