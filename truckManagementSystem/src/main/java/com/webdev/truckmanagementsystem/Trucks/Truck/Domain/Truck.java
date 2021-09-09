package com.webdev.truckmanagementsystem.Trucks.Truck.Domain;

import com.webdev.truckmanagementsystem.Shared.Domain.Ids.OwnerId;
import com.webdev.truckmanagementsystem.Shared.Domain.Ids.TruckId;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Entities.TruckDriver;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Entities.TruckOwner;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Exceptions.NewTotalDistanceInconsistence;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.ValueObjects.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Truck {

    private TruckId truckId;
    private TruckBrand brand;
    private TruckModelYear modelYear;
    private TruckPlate plate;
    private TruckColor color;
    private TruckInsuranceValue insuranceValue;
    private TruckMechanicalRevisionDate mechanicalRevisionDate;
    private TruckTotalDistance totalDistance;
    private OwnerId ownerId;
    private Optional<TruckOwner> owner;
    private Optional<List<TruckDriver>> avaliableDrivers;

    public Truck(TruckId truckId, TruckBrand brand,
                 TruckModelYear modelYear,
                 TruckPlate plate,
                 TruckColor color,
                 TruckInsuranceValue insuranceValue,
                 TruckMechanicalRevisionDate mechanicalRevisionDate,
                 TruckTotalDistance totalDistance,
                 OwnerId ownerId,
                 Optional<TruckOwner> owner,
                 Optional<List<TruckDriver>> avaliableDrivers) {
        this.truckId = truckId;
        this.brand = brand;
        this.modelYear = modelYear;
        this.plate = plate;
        this.color = color;
        this.insuranceValue = insuranceValue;
        this.mechanicalRevisionDate = mechanicalRevisionDate;
        this.totalDistance = totalDistance;
        this.ownerId = ownerId;
        this.owner = owner;
        this.avaliableDrivers = avaliableDrivers;
    }

    public static Truck Create(TruckId truckId, TruckBrand brand,
                               TruckModelYear modelYear,
                               TruckPlate plate,
                               TruckColor color,
                               TruckInsuranceValue insuranceValue,
                               TruckMechanicalRevisionDate mechanicalRevisionDate,
                               OwnerId ownerId)
    {
        Truck truck = new Truck(truckId,
                brand,
                modelYear,
                plate,
                color,
                insuranceValue,
                mechanicalRevisionDate,
                new TruckTotalDistance(0d),
                ownerId,
                Optional.empty(),
                Optional.empty());
        //TODO: Pasos intermedios o eventos derivados
        return truck;
    }

    public void UpdatePlate(TruckPlate plate)
    {
        this.plate = plate;
    }

    public void UpdateColor(TruckColor color)
    {
        this.color = color;
    }

    public void UpdateDistance(TruckTotalDistance distance)
    {
        if (distance.value() < this.totalDistance.value()) {
            throw new NewTotalDistanceInconsistence("La nueva distancia es menor a la distancia actual, por favor revise");
        }
        this.totalDistance = distance;
    }

    public HashMap<String, Object> data() {
        return new HashMap<String, Object>() {{
            put("id", truckId.value());
            put("brand", brand.value());
            put("modelYear", modelYear.value());
            put("plate", plate.value());
            put("color", color.value());
            put("insuranceValue", insuranceValue.value());
            put("mechanicalRevisionDate", mechanicalRevisionDate.value());
            put("ownerId", ownerId.value());
        }};
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
