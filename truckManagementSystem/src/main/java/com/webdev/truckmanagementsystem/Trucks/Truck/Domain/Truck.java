package com.webdev.truckmanagementsystem.Trucks.Truck.Domain;

import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects.TruckBrand;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects.TruckId;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects.TruckModelYear;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects.TruckPlate;
import java.util.Objects;

public class Truck {

    private TruckId truckId;
    private TruckBrand brand;
    private TruckModelYear modelYear;
    private TruckPlate plate;

    public Truck(TruckId truckId, TruckBrand brand, TruckModelYear modelYear, TruckPlate plate) {
        this.truckId = truckId;
        this.brand = brand;
        this.modelYear = modelYear;
        this.plate = plate;
    }

    public static Truck Create(TruckId truckId, TruckBrand brand, TruckModelYear modelYear, TruckPlate plate)
    {
        Truck truck = new Truck(truckId, brand, modelYear, plate);
        //TODO: Pasos intermedios o eventos derivados
        return truck;
    }

    public void UpdatePlate(TruckPlate plate)
    {
        this.plate = plate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Truck truck = (Truck) o;
        return Objects.equals(brand, truck.brand) && Objects.equals(modelYear, truck.modelYear) && Objects.equals(plate, truck.plate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, modelYear, plate);
    }
}
