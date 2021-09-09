package com.webdev.truckmanagementsystem.Trucks.Truck.Application.FindTrucksByOwnerId;

import com.webdev.truckmanagementsystem.Shared.Domain.Ids.OwnerId;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions.NotFoundTrucksOwner;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Ports.TruckRepository;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Truck;

import java.util.List;
import java.util.Optional;

public class TrucksOwnerFinder {

    private TruckRepository repository;

    public TrucksOwnerFinder(TruckRepository repository) {
        this.repository = repository;
    }

    public List<Truck> execute(String ownerId) {
        Optional<List<Truck>> trucks = repository.findByOwnerId(new OwnerId(ownerId));

        if(trucks.isEmpty()) {
            throw new NotFoundTrucksOwner("No hay camiones para el propietario indicado " + ownerId);
        }

        return trucks.get();
    }
}
