package com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions.NotValidMechanicalDateFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TruckMechanicalRevisionDate extends StringValueObject {
    private TruckMechanicalRevisionDate() {}

    public TruckMechanicalRevisionDate(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        dateFormatRule(value);
    }

    private void dateFormatRule(String value) {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        formatter.setLenient(false);
        try {
            formatter.parse(value);
        } catch (ParseException e) {
            throw new NotValidMechanicalDateFormat("El formato de la fecha de revisión mecánica no es correcto");
        }
    }
}
