package com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions.NotEmptyBrand;

public class TruckBrand extends StringValueObject {

    private TruckBrand() {}

    public TruckBrand(String brand) {
        validate(brand);
        this.value = brand;
    }

    private void validate(String brand) {
        requiredBrand(brand);
    }

    private void requiredBrand(String brand) {
        if (brand.length() == 0 || brand == "") {
            throw new NotEmptyBrand("La marca debe tener un valor");
        }
    }
}
