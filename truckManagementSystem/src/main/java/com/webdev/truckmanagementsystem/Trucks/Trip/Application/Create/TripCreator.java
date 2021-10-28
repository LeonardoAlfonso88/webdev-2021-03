package com.webdev.truckmanagementsystem.Trucks.Trip.Application.Create;

import com.webdev.truckmanagementsystem.Shared.Domain.Ids.TripId;
import com.webdev.truckmanagementsystem.Shared.Domain.Ids.TruckId;
import com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Exceptions.TripAlreadyExist;
import com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Ports.TripRepository;
import com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Trip;
import com.webdev.truckmanagementsystem.Trucks.Trip.Domain.ValueObjects.*;

import java.util.Optional;

public class TripCreator {

    private TripRepository repository;

    public TripCreator(TripRepository repository) {
        this.repository = repository;
    }

    public void execute(String tripId, String origin, String destiny, double distance, double loadWeight,
                        String initialDate, String plannedFinalDate, String truckId) {
        this.validate(tripId);
        Trip trip = Trip.Create(new TripId(tripId), new TripOrigin(origin), new TripDestiny(destiny), new TripDistance(distance),
                new TripLoadWeight(loadWeight), new TripInitialDate(initialDate), new TripPlannedFinalDate(plannedFinalDate),
                new TruckId(truckId));
        repository.save(trip);
    }

    private void validate(String tripId) {
        Optional<Trip> trip = repository.find(new TripId(tripId));
        if(trip.isPresent()) {
            throw new TripAlreadyExist("El viaje con id " + tripId + " ya existe.");
        }
    }

}
