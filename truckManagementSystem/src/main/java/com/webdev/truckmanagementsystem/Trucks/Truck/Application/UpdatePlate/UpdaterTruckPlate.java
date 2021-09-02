package com.webdev.truckmanagementsystem.Trucks.Truck.Application.UpdatePlate;

import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions.TruckNotFound;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Ports.TruckRepository;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Services.DomainTruckFinder;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Truck;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects.TruckId;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects.TruckPlate;

import java.util.Optional;

public class UpdaterTruckPlate {

    private TruckRepository repository;
    private DomainTruckFinder serviceFinder;

    public UpdaterTruckPlate(TruckRepository repository) {
        this.repository = repository;
        serviceFinder = new DomainTruckFinder(this.repository);
    }

    public void Execute(String id, String plate) {

        Truck finalTruck = serviceFinder.Execute(id);

        finalTruck.UpdatePlate(new TruckPlate(plate));

        repository.save(finalTruck);
    }
}
