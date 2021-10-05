package com.webdev.truckmanagementsystem.Shared.Domain.DomainEvents;

import com.webdev.truckmanagementsystem.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class TripFinalizedDomainEvent extends DomainEvent {

    private final double distance;

    public TripFinalizedDomainEvent() {
        super(null);
        this.distance = 0;
    }

    public TripFinalizedDomainEvent(String aggregateId, double distance) {
        super(aggregateId);
        this.distance = distance;
    }

    public TripFinalizedDomainEvent(String aggregateId, String eventId, String occurredOn, double distance) {
        super(aggregateId, eventId, occurredOn);
        this.distance = distance;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public String eventName() {
        return "trip.finalized";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>() {{
           put("distance", distance);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new TripFinalizedDomainEvent(aggregateId, eventId, occurredOn, (double) body.get("distance"));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripFinalizedDomainEvent that = (TripFinalizedDomainEvent) o;
        return Double.compare(that.distance, distance) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(distance);
    }
}
