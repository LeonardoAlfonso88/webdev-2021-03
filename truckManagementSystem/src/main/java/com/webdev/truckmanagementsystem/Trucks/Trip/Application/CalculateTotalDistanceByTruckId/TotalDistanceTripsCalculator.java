package com.webdev.truckmanagementsystem.Trucks.Trip.Application.CalculateTotalDistanceByTruckId;

import com.webdev.truckmanagementsystem.Shared.Domain.Ids.TruckId;
import com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Exceptions.NotFoundTripsByTruck;
import com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Ports.TripRepository;
import com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Trip;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TotalDistanceTripsCalculator {

    private TripRepository repository;

    public TotalDistanceTripsCalculator(TripRepository repository) {
        this.repository = repository;
    }

    public Double execute(String truckId) {
        Optional<List<Trip>> trips = repository.findByTruckId(new TruckId(truckId));

        if (trips.isEmpty()) {
            throw new NotFoundTripsByTruck("No hay viajes relacionados al camión con id " + truckId);
        }

        return trips.get().stream().mapToDouble(t -> (double)t.data().get("distance")).sum();
    }
}
