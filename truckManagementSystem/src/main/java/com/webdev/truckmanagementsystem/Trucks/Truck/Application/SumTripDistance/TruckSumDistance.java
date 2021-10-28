package com.webdev.truckmanagementsystem.Trucks.Truck.Application.SumTripDistance;

import com.webdev.truckmanagementsystem.Shared.Domain.Ids.TruckId;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Ports.TruckRepository;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Truck;

import java.util.Optional;

public class TruckSumDistance {

    private TruckRepository repository;

    public TruckSumDistance(TruckRepository repository) {
        this.repository = repository;
    }

    public void execute(String truckId, double distance){
        Optional<Truck> optionalTruck = this.repository.find(new TruckId(truckId));
        if(optionalTruck.isPresent()) {
            Truck truck = optionalTruck.get();
            truck.sumTripDistance(distance);
            this.repository.update(truck);
        }
    }
}
