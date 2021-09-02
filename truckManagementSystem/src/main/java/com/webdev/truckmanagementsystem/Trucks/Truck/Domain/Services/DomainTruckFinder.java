package com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Services;

import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions.TruckNotFound;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Ports.TruckRepository;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Truck;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects.TruckId;

import java.util.Optional;

public class DomainTruckFinder {

    private TruckRepository repository;

    public DomainTruckFinder(TruckRepository repository) {
        this.repository = repository;
    }

    public Truck Execute(String id) {
        Optional<Truck> truckOptional = repository.find(new TruckId(id));

        if (truckOptional.isEmpty()) {
            throw new TruckNotFound("El camión con Id" + id + " no ha sido encontrado");
        }

        return truckOptional.get();
    }
}
