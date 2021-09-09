package com.webdev.truckmanagementsystem.Trucks.Trip.Domain.ValueObjects;

import com.webdev.truckmanagementsystem.Shared.Domain.Aggregate.StringValueObject;
import com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Exceptions.NotValidTripFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TripRealFinalDate extends StringValueObject {

    public TripRealFinalDate(String date) {
        validate(date);
        this.value = date;
    }

    private void validate(String date) {
        dateFormatRule(date);
    }

    private void dateFormatRule(String date) {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        formatter.setLenient(false);
        try {
            formatter.parse(date);
        } catch (ParseException e) {
            throw new NotValidTripFormat("El formato de la fecha real de finalización del viaje no es correcto");
        }
    }
}
