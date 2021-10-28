package com.webdev.truckmanagementsystem.Trucks.Truck.Application.All;

import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Ports.TruckRepository;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Truck;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TruckAll {

    private TruckRepository repository;

    public TruckAll(TruckRepository repository) {
        this.repository = repository;
    }

    public TruckAllResponse execute() {
        Optional<List<Truck>> trucksOptional = repository.all();
        List<Truck> trucks = new ArrayList<>();
        if(trucksOptional.isPresent()) {
            trucks = trucksOptional.get();
        }
        return new TruckAllResponse(trucks);
    }
}
