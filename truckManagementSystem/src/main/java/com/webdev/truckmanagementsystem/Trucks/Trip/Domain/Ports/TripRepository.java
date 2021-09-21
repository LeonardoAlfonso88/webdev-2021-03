package com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Ports;

import com.webdev.truckmanagementsystem.Shared.Domain.Ids.TripId;
import com.webdev.truckmanagementsystem.Shared.Domain.Ids.TruckId;
import com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Trip;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface TripRepository {
    void save(Trip trip);
    void update(Trip trip);
    Optional<Trip> find (TripId id);
    Optional<List<Trip>> all();
    void delete(Trip trip);
    Optional<List<Trip>> findByTruckId(TruckId truckId);
}
