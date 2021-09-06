package com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.DoubleValueObject;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions.NotPositiveInsuranceValue;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions.NotValidMaxInsuranceValue;

public class TruckInsuranceValue extends DoubleValueObject {
    private TruckInsuranceValue() {}

    public TruckInsuranceValue(Double value) {
        validate(value);
        this.value = value;
    }

    private void validate(Double value) {
        positiveValue(value);
        maxLimitValue(value);
    }

    private void maxLimitValue(Double value) {
        if (value > 1000000) {
            throw new NotValidMaxInsuranceValue("El valor no debe ser superior a $1.000.000");
        }
    }

    private void positiveValue(Double value) {
        if (value < 0) {
            throw new NotPositiveInsuranceValue("El valor debe ser positivo");
        }
    }
}
