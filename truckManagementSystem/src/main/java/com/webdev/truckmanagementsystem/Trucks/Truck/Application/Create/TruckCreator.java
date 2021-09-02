package com.webdev.truckmanagementsystem.Trucks.Truck.Application.Create;

import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Ports.TruckRepository;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Truck;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects.TruckBrand;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects.TruckId;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects.TruckModelYear;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects.TruckPlate;

public class TruckCreator {

    private TruckRepository repository;

    public TruckCreator(TruckRepository repository) {
        this.repository = repository;
    }

    public void execute(String id, String brand, Integer modelYear, String plate) {
        Truck truck = Truck.Create(new TruckId(id), new TruckBrand(brand), new TruckModelYear(modelYear), new TruckPlate(plate));
        repository.save(truck);
    }
}
