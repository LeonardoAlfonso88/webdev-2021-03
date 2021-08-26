package com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.IntegerValueObject;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions.TruckModelYearLengthNotValid;

public class TruckModelYear extends IntegerValueObject {
    private TruckModelYear() {
    }

    public TruckModelYear(Integer modelYear) {
        validate(modelYear);
        this.value = modelYear;
    }

    private void validate(Integer modelYear) throws RuntimeException {
        lenghtValidate(modelYear);
        validYear(modelYear);
    }

    private void lenghtValidate(Integer modelYear) throws RuntimeException {
        if (modelYear.toString().length() != 4)
        {
            throw new TruckModelYearLengthNotValid("La longitud de la modelo no es correcta");
        }
    }
    private void validYear(Integer modelYear) throws RuntimeException {

    }
}
