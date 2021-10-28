package com.webdev.truckmanagementsystem.Trucks.Trip.Application.FinalizedTrip;

import com.webdev.truckmanagementsystem.Shared.Domain.Bus.Event.EventBus;
import com.webdev.truckmanagementsystem.Shared.Domain.Ids.TripId;
import com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Exceptions.TripNotExist;
import com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Ports.TripRepository;
import com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Trip;

import java.util.Optional;

public class TripFinalized {

    private TripRepository repository;
    private EventBus eventBus;

    public TripFinalized(TripRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus = eventBus;
    }

    public void execute(String tripId) {
        Optional<Trip> tripOptional = this.repository.find(new TripId(tripId));
        if(tripOptional.isEmpty()) {
            throw new TripNotExist("El viaje con id " + tripId + " no existe.");
        }
        Trip trip = tripOptional.get();
        trip.finalizedTrip();
        this.repository.update(trip);
        this.eventBus.publish(trip.pullDomainEvents());
    }
}
