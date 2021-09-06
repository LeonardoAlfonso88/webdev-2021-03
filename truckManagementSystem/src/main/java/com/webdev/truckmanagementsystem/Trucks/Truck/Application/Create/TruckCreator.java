package com.webdev.truckmanagementsystem.Trucks.Truck.Application.Create;

import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Ports.TruckRepository;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Truck;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects.*;

public class TruckCreator {

    private TruckRepository repository;

    public TruckCreator(TruckRepository repository) {
        this.repository = repository;
    }

    public void execute(String id,
                        String brand,
                        Integer modelYear,
                        String plate,
                        String color,
                        Double insuranceValue,
                        String mechanicalDate) {

        Truck truck = Truck.Create(new TruckId(id),
                new TruckBrand(brand),
                new TruckModelYear(modelYear),
                new TruckPlate(plate),
                new TruckColor(color),
                new TruckInsuranceValue(insuranceValue),
                new TruckMechanicalRevisionDate(mechanicalDate));
        repository.save(truck);
    }
}



