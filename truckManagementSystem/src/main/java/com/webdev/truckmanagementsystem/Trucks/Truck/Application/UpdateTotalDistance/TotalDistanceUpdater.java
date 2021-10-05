package com.webdev.truckmanagementsystem.Trucks.Truck.Application.UpdateTotalDistance;

import com.webdev.truckmanagementsystem.Trucks.Trip.Application.CalculateTotalDistanceByTruckId.TotalDistanceTripsCalculator;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Ports.TruckRepository;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Services.DomainTruckFinder;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Truck;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects.TruckTotalDistance;

public class TotalDistanceUpdater {

    private TruckRepository repository;
    private TotalDistanceTripsCalculator useCase;
    private DomainTruckFinder serviceFinder;

    public TotalDistanceUpdater(TruckRepository repository, TotalDistanceTripsCalculator useCase) {
        this.repository = repository;
        this.useCase = useCase;
        this.serviceFinder = new DomainTruckFinder(repository);
    }

    public void execute(String truckId)
    {
        Truck truck = serviceFinder.execute(truckId);
        double newDistance = useCase.execute(truckId);
        truck.updateDistance(new TruckTotalDistance(newDistance));
        repository.save(truck);
    }
}
