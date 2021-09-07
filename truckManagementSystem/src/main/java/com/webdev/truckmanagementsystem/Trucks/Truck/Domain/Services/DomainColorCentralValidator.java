package com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Services;

import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions.NotColorCentralValid;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Ports.TruckColorValidator;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects.TruckColor;

public class DomainColorCentralValidator {

    private TruckColorValidator colorValidator;

    public DomainColorCentralValidator(TruckColorValidator colorValidator) {
        this.colorValidator = colorValidator;
    }

    public TruckColor execute(String color) {
        TruckColor colorVO = new TruckColor(color);

        if (!colorValidator.validateColor(colorVO)) {
            throw new NotColorCentralValid("El color no es válido por la central de automotores");
        }

        return colorVO;
    }
}
