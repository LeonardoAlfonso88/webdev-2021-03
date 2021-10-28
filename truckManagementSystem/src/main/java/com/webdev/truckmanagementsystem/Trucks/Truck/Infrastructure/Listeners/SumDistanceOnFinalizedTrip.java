package com.webdev.truckmanagementsystem.Trucks.Truck.Infrastructure.Listeners;

import com.webdev.truckmanagementsystem.Shared.Domain.Bus.Event.Spring.DomainEventSubscriber;
import com.webdev.truckmanagementsystem.Shared.Domain.DomainEvents.TripFinalizedDomainEvent;
import com.webdev.truckmanagementsystem.Trucks.Truck.Application.SumTripDistance.TruckSumDistance;
import org.springframework.context.event.EventListener;

@DomainEventSubscriber({TripFinalizedDomainEvent.class})
public final class SumDistanceOnFinalizedTrip {

    private TruckSumDistance truckSumDistance;

    public SumDistanceOnFinalizedTrip(TruckSumDistance truckSumDistance) {
        this.truckSumDistance = truckSumDistance;
    }

    @EventListener
    public void on(TripFinalizedDomainEvent event) {
        this.truckSumDistance.execute(event.aggregateId(), event.getDistance());
    }
}
