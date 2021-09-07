package com.webdev.truckmanagementsystem.Trucks.Truck.Application.Create;

import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions.NotColorCentralValid;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Ports.TruckColorValidator;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Ports.TruckRepository;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Services.DomainColorCentralValidator;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Truck;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects.*;

public class TruckCreator {

    private TruckRepository repository;
    private TruckColorValidator colorValidator;
    private DomainColorCentralValidator serviceColorValidator;

    public TruckCreator(TruckRepository repository,TruckColorValidator colorValidator) {
        this.repository = repository;
        this.colorValidator = colorValidator;
        this.serviceColorValidator = new DomainColorCentralValidator(colorValidator);
    }

    public void execute(String id,
                        String brand,
                        Integer modelYear,
                        String plate,
                        String color,
                        Double insuranceValue,
                        String mechanicalDate) {

        TruckColor colorVO = serviceColorValidator.execute(color);

        Truck truck = Truck.Create(new TruckId(id),
                new TruckBrand(brand),
                new TruckModelYear(modelYear),
                new TruckPlate(plate),
                colorVO,
                new TruckInsuranceValue(insuranceValue),
                new TruckMechanicalRevisionDate(mechanicalDate));
        repository.save(truck);
    }
}



