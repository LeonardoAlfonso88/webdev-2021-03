package com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions.ColorFormatNotValid;

import java.util.regex.Pattern;

public class TruckColor extends StringValueObject {

    private TruckColor() {}

    public TruckColor(String color) {
        validate(color);
        this.value = color;
    }

    private void validate(String color) {
        hexaColorValidate(color);
    }

    private void hexaColorValidate(String color) {
        Pattern p = Pattern.compile("^#[A-Fa-f0-9]{6}$");
        if (!p.matcher(color).find()) {
            throw new ColorFormatNotValid("Color inválido");
        }
    }
}
