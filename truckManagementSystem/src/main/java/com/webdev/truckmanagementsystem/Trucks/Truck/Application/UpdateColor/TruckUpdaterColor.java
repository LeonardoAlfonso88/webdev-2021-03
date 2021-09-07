package com.webdev.truckmanagementsystem.Trucks.Truck.Application.UpdateColor;

import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Ports.TruckColorValidator;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Ports.TruckRepository;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Services.DomainColorCentralValidator;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Services.DomainTruckFinder;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Truck;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects.TruckColor;

public class TruckUpdaterColor {

    private TruckRepository repository;
    private TruckColorValidator colorValidator;
    private DomainTruckFinder serviceFinder;
    private DomainColorCentralValidator serviceColorValidator;

    public TruckUpdaterColor(TruckRepository repository, TruckColorValidator colorValidator) {
        this.repository = repository;
        this.colorValidator = colorValidator;
        this.serviceFinder = new DomainTruckFinder(repository);
        this.serviceColorValidator = new DomainColorCentralValidator(colorValidator);
    }

    public void execute(String id, String color) {
        //1. Encotrar el camión
        Truck truck = serviceFinder.execute(id);

        //2. Verificar que el color sea valido
        TruckColor colorVO = serviceColorValidator.execute(color);

        //3. Cambiar el color del camión
        truck.UpdateColor(colorVO);

        //4. Salvar el camión modificado
        repository.save(truck);
    }
}
