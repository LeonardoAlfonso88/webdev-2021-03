package com.webdev.truckmanagementsystem.Trucks.Truck.Application.Find;

import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Ports.TruckRepository;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Services.DomainTruckFinder;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Truck;

public class TruckFinder {

    private TruckRepository repository;
    private DomainTruckFinder serviceFinder;

    public TruckFinder(TruckRepository repository) {
        this.repository = repository;
        serviceFinder = new DomainTruckFinder(this.repository);
    }

    public Truck execute(String id) {
        return serviceFinder.execute(id);
    }
}
