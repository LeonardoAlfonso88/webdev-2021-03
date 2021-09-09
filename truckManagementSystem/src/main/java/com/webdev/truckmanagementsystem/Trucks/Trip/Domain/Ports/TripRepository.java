package com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Ports;

import com.webdev.truckmanagementsystem.Shared.Domain.Ids.TruckId;
import com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Trip;

import java.util.List;
import java.util.Optional;

public interface TripRepository {
    void save(Trip trip);
    Optional<List<Trip>> findByTruckId(TruckId truckId);
}
