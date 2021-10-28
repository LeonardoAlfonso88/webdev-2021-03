package com.webdev.truckmanagementsystem.Shared.Domain.Bus.Event.RabbitMQ;

import com.webdev.truckmanagementsystem.Shared.Domain.Bus.Event.DomainEvent;
import com.webdev.truckmanagementsystem.Shared.Domain.DomainEvents.TripFinalizedDomainEvent;

import java.util.HashMap;

public class DomainEventsInformation {

    private final HashMap<String, Class<? extends DomainEvent>> indexedDomainEvent = new HashMap<>();
    private final HashMap<String, String> domainEventSubscribers = new HashMap<>();

    public DomainEventsInformation() {
        indexedDomainEvent.put("trip.finalized", TripFinalizedDomainEvent.class);
        domainEventSubscribers.put("truckManagementSystem.Trucks.Trip.trip.finalized", "SumDistanceOnFinalizedTrip");
    }

    public Class<? extends DomainEvent> getDomainEvent(String name) {
        return indexedDomainEvent.get(name);
    }

    public boolean validateEventSubscriber(String name) {
        return domainEventSubscribers.containsKey(name);
    }

    public String getEventSubscriber(String name) {
        return domainEventSubscribers.get(name);
    }

}
