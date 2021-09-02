package com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions.PlateFormatNotValid;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions.PlateLengthNotValid;

import java.util.regex.Pattern;

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
        Pattern p = Pattern.compile("^[a-zA-Z]*$");
        String letters = plate.substring(0,2);
        if (!p.matcher(letters).find()) {
            throw new PlateFormatNotValid("Placa inválida");
        }
    }

    private void plateNumericValidate(String plate) {
        Pattern p = Pattern.compile("^[0-9]*$");
        String numbers = plate.substring(3,5);
        if (!p.matcher(numbers).find()) {
            throw new PlateFormatNotValid("Placa inválida");
        }
    }

}


